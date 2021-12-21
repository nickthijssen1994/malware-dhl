package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ScaleKeyframeAnimation;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class AnimatableScaleValue
  extends BaseAnimatableValue<ScaleXY, ScaleXY>
{
  AnimatableScaleValue()
  {
    this(new ScaleXY(1.0F, 1.0F));
  }
  
  public AnimatableScaleValue(ScaleXY paramScaleXY)
  {
    super(paramScaleXY);
  }
  
  public AnimatableScaleValue(List paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new ScaleKeyframeAnimation(keyframes);
  }
}
