package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedFloatValue
  extends LottieInterpolatedValue<Float>
{
  public LottieInterpolatedFloatValue(Float paramFloat1, Float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }
  
  public LottieInterpolatedFloatValue(Float paramFloat1, Float paramFloat2, Interpolator paramInterpolator)
  {
    super(paramFloat1, paramFloat2, paramInterpolator);
  }
  
  Float interpolateValue(Float paramFloat1, Float paramFloat2, float paramFloat)
  {
    return Float.valueOf(MiscUtils.lerp(paramFloat1.floatValue(), paramFloat2.floatValue(), paramFloat));
  }
}
