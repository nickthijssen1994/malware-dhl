package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedPointValue
  extends LottieInterpolatedValue<PointF>
{
  private final PointF point = new PointF();
  
  public LottieInterpolatedPointValue(PointF paramPointF1, PointF paramPointF2)
  {
    super(paramPointF1, paramPointF2);
  }
  
  public LottieInterpolatedPointValue(PointF paramPointF1, PointF paramPointF2, Interpolator paramInterpolator)
  {
    super(paramPointF1, paramPointF2, paramInterpolator);
  }
  
  PointF interpolateValue(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    point.set(MiscUtils.lerp(x, x, paramFloat), MiscUtils.lerp(y, y, paramFloat));
    return point;
  }
}
