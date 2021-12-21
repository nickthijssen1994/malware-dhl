package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativePointValueCallback
  extends LottieValueCallback<PointF>
{
  private final PointF point = new PointF();
  
  public LottieRelativePointValueCallback() {}
  
  public LottieRelativePointValueCallback(PointF paramPointF)
  {
    super(paramPointF);
  }
  
  public PointF getOffset(LottieFrameInfo paramLottieFrameInfo)
  {
    if (value != null) {
      return (PointF)value;
    }
    throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
  }
  
  public final PointF getValue(LottieFrameInfo paramLottieFrameInfo)
  {
    point.set(MiscUtils.lerp(getStartValuex, getEndValuex, paramLottieFrameInfo.getInterpolatedKeyframeProgress()), MiscUtils.lerp(getStartValuey, getEndValuey, paramLottieFrameInfo.getInterpolatedKeyframeProgress()));
    paramLottieFrameInfo = getOffset(paramLottieFrameInfo);
    point.offset(x, y);
    return point;
  }
}
