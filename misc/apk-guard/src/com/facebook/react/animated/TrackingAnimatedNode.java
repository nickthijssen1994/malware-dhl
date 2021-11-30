package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;

class TrackingAnimatedNode
  extends AnimatedNode
{
  private final JavaOnlyMap mAnimationConfig;
  private final int mAnimationId;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final int mToValueNode;
  private final int mValueNode;
  
  TrackingAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    mAnimationId = paramReadableMap.getInt("animationId");
    mToValueNode = paramReadableMap.getInt("toValue");
    mValueNode = paramReadableMap.getInt("value");
    mAnimationConfig = JavaOnlyMap.deepClone(paramReadableMap.getMap("animationConfig"));
  }
  
  public void update()
  {
    AnimatedNode localAnimatedNode = mNativeAnimatedNodesManager.getNodeById(mToValueNode);
    mAnimationConfig.putDouble("toValue", ((ValueAnimatedNode)localAnimatedNode).getValue());
    mNativeAnimatedNodesManager.startAnimatingNode(mAnimationId, mValueNode, mAnimationConfig, null);
  }
}
