package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import java.util.List;

public class AnimatableIntegerValue
  extends BaseAnimatableValue<Integer, Integer>
{
  public AnimatableIntegerValue()
  {
    super(Integer.valueOf(100));
  }
  
  public AnimatableIntegerValue(List paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new IntegerKeyframeAnimation(keyframes);
  }
}
