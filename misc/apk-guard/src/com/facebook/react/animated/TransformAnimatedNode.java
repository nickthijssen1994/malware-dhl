package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TransformAnimatedNode
  extends AnimatedNode
{
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final List<TransformConfig> mTransformConfigs;
  
  TransformAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    paramReadableMap = paramReadableMap.getArray("transforms");
    mTransformConfigs = new ArrayList(paramReadableMap.size());
    int i = 0;
    while (i < paramReadableMap.size())
    {
      ReadableMap localReadableMap = paramReadableMap.getMap(i);
      String str = localReadableMap.getString("property");
      Object localObject;
      if (localReadableMap.getString("type").equals("animated"))
      {
        localObject = new AnimatedTransformConfig(null);
        mProperty = str;
        mNodeTag = localReadableMap.getInt("nodeTag");
        mTransformConfigs.add(localObject);
      }
      else
      {
        localObject = new StaticTransformConfig(null);
        mProperty = str;
        mValue = localReadableMap.getDouble("value");
        mTransformConfigs.add(localObject);
      }
      i += 1;
    }
    mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
  }
  
  public void collectViewUpdates(JavaOnlyMap paramJavaOnlyMap)
  {
    ArrayList localArrayList = new ArrayList(mTransformConfigs.size());
    Iterator localIterator = mTransformConfigs.iterator();
    while (localIterator.hasNext())
    {
      TransformConfig localTransformConfig = (TransformConfig)localIterator.next();
      double d;
      if ((localTransformConfig instanceof AnimatedTransformConfig))
      {
        int i = mNodeTag;
        AnimatedNode localAnimatedNode = mNativeAnimatedNodesManager.getNodeById(i);
        if (localAnimatedNode != null)
        {
          if ((localAnimatedNode instanceof ValueAnimatedNode))
          {
            d = ((ValueAnimatedNode)localAnimatedNode).getValue();
          }
          else
          {
            paramJavaOnlyMap = new StringBuilder();
            paramJavaOnlyMap.append("Unsupported type of node used as a transform child node ");
            paramJavaOnlyMap.append(localAnimatedNode.getClass());
            throw new IllegalArgumentException(paramJavaOnlyMap.toString());
          }
        }
        else {
          throw new IllegalArgumentException("Mapped style node does not exists");
        }
      }
      else
      {
        d = mValue;
      }
      localArrayList.add(JavaOnlyMap.of(new Object[] { mProperty, Double.valueOf(d) }));
    }
    paramJavaOnlyMap.putArray("transform", JavaOnlyArray.from(localArrayList));
  }
  
  private class AnimatedTransformConfig
    extends TransformAnimatedNode.TransformConfig
  {
    public int mNodeTag;
    
    private AnimatedTransformConfig()
    {
      super(null);
    }
  }
  
  private class StaticTransformConfig
    extends TransformAnimatedNode.TransformConfig
  {
    public double mValue;
    
    private StaticTransformConfig()
    {
      super(null);
    }
  }
  
  private class TransformConfig
  {
    public String mProperty;
    
    private TransformConfig() {}
  }
}
