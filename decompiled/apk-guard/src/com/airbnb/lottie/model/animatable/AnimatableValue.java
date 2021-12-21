package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

public abstract interface AnimatableValue<K, A>
{
  public abstract BaseKeyframeAnimation createAnimation();
  
  public abstract List getKeyframes();
  
  public abstract boolean isStatic();
}
