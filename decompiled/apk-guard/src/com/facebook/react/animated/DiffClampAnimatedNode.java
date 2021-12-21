package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

class DiffClampAnimatedNode
  extends ValueAnimatedNode
{
  private final int mInputNodeTag;
  private double mLastValue;
  private final double mMax;
  private final double mMin;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  
  public DiffClampAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    mInputNodeTag = paramReadableMap.getInt("input");
    mMin = paramReadableMap.getDouble("min");
    mMax = paramReadableMap.getDouble("max");
    mLastValue = 0.0D;
    mValue = 0.0D;
  }
  
  private double getInputNodeValue()
  {
    AnimatedNode localAnimatedNode = mNativeAnimatedNodesManager.getNodeById(mInputNodeTag);
    if ((localAnimatedNode != null) && ((localAnimatedNode instanceof ValueAnimatedNode))) {
      return ((ValueAnimatedNode)localAnimatedNode).getValue();
    }
    throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.DiffClamp node");
  }
  
  public void update()
  {
    double d1 = getInputNodeValue();
    double d2 = mLastValue;
    mLastValue = d1;
    mValue = Math.min(Math.max(mValue + (d1 - d2), mMin), mMax);
  }
}
