package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import java.util.List;

public class AnimatableGradientColorValue
  extends BaseAnimatableValue<GradientColor, GradientColor>
{
  public AnimatableGradientColorValue(List paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new GradientColorKeyframeAnimation(keyframes);
  }
}
