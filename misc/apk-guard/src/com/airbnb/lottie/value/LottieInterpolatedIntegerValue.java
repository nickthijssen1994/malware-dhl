package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedIntegerValue
  extends LottieInterpolatedValue<Integer>
{
  public LottieInterpolatedIntegerValue(Integer paramInteger1, Integer paramInteger2)
  {
    super(paramInteger1, paramInteger2);
  }
  
  public LottieInterpolatedIntegerValue(Integer paramInteger1, Integer paramInteger2, Interpolator paramInterpolator)
  {
    super(paramInteger1, paramInteger2, paramInterpolator);
  }
  
  Integer interpolateValue(Integer paramInteger1, Integer paramInteger2, float paramFloat)
  {
    return Integer.valueOf(MiscUtils.lerp(paramInteger1.intValue(), paramInteger2.intValue(), paramFloat));
  }
}
