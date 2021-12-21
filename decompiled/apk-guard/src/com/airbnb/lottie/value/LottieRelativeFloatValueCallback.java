package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeFloatValueCallback
  extends LottieValueCallback<Float>
{
  public LottieRelativeFloatValueCallback() {}
  
  public LottieRelativeFloatValueCallback(Float paramFloat)
  {
    super(paramFloat);
  }
  
  public Float getOffset(LottieFrameInfo paramLottieFrameInfo)
  {
    if (value != null) {
      return (Float)value;
    }
    throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
  }
  
  public Float getValue(LottieFrameInfo paramLottieFrameInfo)
  {
    return Float.valueOf(MiscUtils.lerp(((Float)paramLottieFrameInfo.getStartValue()).floatValue(), ((Float)paramLottieFrameInfo.getEndValue()).floatValue(), paramLottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(paramLottieFrameInfo).floatValue());
  }
}
