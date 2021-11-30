package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeIntegerValueCallback
  extends LottieValueCallback<Integer>
{
  public LottieRelativeIntegerValueCallback() {}
  
  public Integer getOffset(LottieFrameInfo paramLottieFrameInfo)
  {
    if (value != null) {
      return (Integer)value;
    }
    throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
  }
  
  public Integer getValue(LottieFrameInfo paramLottieFrameInfo)
  {
    return Integer.valueOf(MiscUtils.lerp(((Integer)paramLottieFrameInfo.getStartValue()).intValue(), ((Integer)paramLottieFrameInfo.getEndValue()).intValue(), paramLottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(paramLottieFrameInfo).intValue());
  }
}
