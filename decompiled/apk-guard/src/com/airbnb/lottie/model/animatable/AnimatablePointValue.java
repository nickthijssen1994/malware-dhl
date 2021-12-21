package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import java.util.List;

public class AnimatablePointValue
  extends BaseAnimatableValue<PointF, PointF>
{
  public AnimatablePointValue(List paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new PointKeyframeAnimation(keyframes);
  }
}
