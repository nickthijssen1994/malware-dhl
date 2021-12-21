package com.airbnb.lottie.value;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

abstract class LottieInterpolatedValue<T>
  extends LottieValueCallback<T>
{
  private final T endValue;
  private final Interpolator interpolator;
  private final T startValue;
  
  LottieInterpolatedValue(Object paramObject1, Object paramObject2)
  {
    this(paramObject1, paramObject2, new LinearInterpolator());
  }
  
  LottieInterpolatedValue(Object paramObject1, Object paramObject2, Interpolator paramInterpolator)
  {
    startValue = paramObject1;
    endValue = paramObject2;
    interpolator = paramInterpolator;
  }
  
  public Object getValue(LottieFrameInfo paramLottieFrameInfo)
  {
    float f = interpolator.getInterpolation(paramLottieFrameInfo.getOverallProgress());
    return interpolateValue(startValue, endValue, f);
  }
  
  abstract Object interpolateValue(Object paramObject1, Object paramObject2, float paramFloat);
}
