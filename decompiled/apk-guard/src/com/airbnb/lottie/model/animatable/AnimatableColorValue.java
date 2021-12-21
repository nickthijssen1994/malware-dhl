package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import java.util.List;

public class AnimatableColorValue
  extends BaseAnimatableValue<Integer, Integer>
{
  public AnimatableColorValue(List paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new ColorKeyframeAnimation(keyframes);
  }
}
