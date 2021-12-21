package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation
  extends KeyframeAnimation<GradientColor>
{
  private final GradientColor gradientColor;
  
  public GradientColorKeyframeAnimation(List paramList)
  {
    super(paramList);
    int i = 0;
    paramList = (GradientColor)get0startValue;
    if (paramList != null) {
      i = paramList.getSize();
    }
    gradientColor = new GradientColor(new float[i], new int[i]);
  }
  
  GradientColor getValue(Keyframe paramKeyframe, float paramFloat)
  {
    gradientColor.lerp((GradientColor)startValue, (GradientColor)endValue, paramFloat);
    return gradientColor;
  }
}
