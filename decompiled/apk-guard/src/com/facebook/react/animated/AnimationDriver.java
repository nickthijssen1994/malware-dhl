package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

abstract class AnimationDriver
{
  int animations;
  ValueAnimatedNode mAnimatedValue;
  Callback mEndCallback;
  boolean mHasFinished = false;
  
  AnimationDriver() {}
  
  public void resetConfig(ReadableMap paramReadableMap)
  {
    paramReadableMap = new StringBuilder();
    paramReadableMap.append("Animation config for ");
    paramReadableMap.append(getClass().getSimpleName());
    paramReadableMap.append(" cannot be reset");
    throw new JSApplicationCausedNativeException(paramReadableMap.toString());
  }
  
  public abstract void runAnimationStep(long paramLong);
}
