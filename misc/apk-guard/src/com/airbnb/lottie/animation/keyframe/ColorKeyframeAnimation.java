package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class ColorKeyframeAnimation
  extends KeyframeAnimation<Integer>
{
  public ColorKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  public int getIntValue()
  {
    return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
  }
  
  public int getIntValue(Keyframe paramKeyframe, float paramFloat)
  {
    if ((startValue != null) && (endValue != null))
    {
      int i = ((Integer)startValue).intValue();
      int j = ((Integer)endValue).intValue();
      if (valueCallback != null)
      {
        paramKeyframe = (Integer)valueCallback.getValueInternal(startFrame, endFrame.floatValue(), Integer.valueOf(i), Integer.valueOf(j), paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
        if (paramKeyframe != null) {
          return paramKeyframe.intValue();
        }
      }
      return GammaEvaluator.evaluate(MiscUtils.clamp(paramFloat, 0.0F, 1.0F), i, j);
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  Integer getValue(Keyframe paramKeyframe, float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramKeyframe, paramFloat));
  }
}
