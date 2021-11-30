package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.util.List;

public class AnimatableFloatValue
  extends BaseAnimatableValue<Float, Float>
{
  AnimatableFloatValue()
  {
    super(Float.valueOf(0.0F));
  }
  
  public AnimatableFloatValue(List paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new FloatKeyframeAnimation(keyframes);
  }
}
