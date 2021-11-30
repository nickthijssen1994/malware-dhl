package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StyleAnimatedNode
  extends AnimatedNode
{
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final Map<String, Integer> mPropMapping;
  
  StyleAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    paramReadableMap = paramReadableMap.getMap("style");
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    mPropMapping = new HashMap();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      int i = paramReadableMap.getInt(str);
      mPropMapping.put(str, Integer.valueOf(i));
    }
    mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
  }
  
  public void collectViewUpdates(JavaOnlyMap paramJavaOnlyMap)
  {
    Iterator localIterator = mPropMapping.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      AnimatedNode localAnimatedNode = mNativeAnimatedNodesManager.getNodeById(((Integer)localEntry.getValue()).intValue());
      if (localAnimatedNode != null)
      {
        if ((localAnimatedNode instanceof TransformAnimatedNode))
        {
          ((TransformAnimatedNode)localAnimatedNode).collectViewUpdates(paramJavaOnlyMap);
        }
        else if ((localAnimatedNode instanceof ValueAnimatedNode))
        {
          paramJavaOnlyMap.putDouble((String)localEntry.getKey(), ((ValueAnimatedNode)localAnimatedNode).getValue());
        }
        else
        {
          paramJavaOnlyMap = new StringBuilder();
          paramJavaOnlyMap.append("Unsupported type of node used in property node ");
          paramJavaOnlyMap.append(localAnimatedNode.getClass());
          throw new IllegalArgumentException(paramJavaOnlyMap.toString());
        }
      }
      else {
        throw new IllegalArgumentException("Mapped style node does not exists");
      }
    }
  }
}
