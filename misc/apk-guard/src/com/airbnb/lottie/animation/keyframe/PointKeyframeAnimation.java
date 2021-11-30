package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PointKeyframeAnimation
  extends KeyframeAnimation<PointF>
{
  private final PointF point = new PointF();
  
  public PointKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  public PointF getValue(Keyframe paramKeyframe, float paramFloat)
  {
    if ((startValue != null) && (endValue != null))
    {
      PointF localPointF1 = (PointF)startValue;
      PointF localPointF2 = (PointF)endValue;
      if (valueCallback != null)
      {
        paramKeyframe = (PointF)valueCallback.getValueInternal(startFrame, endFrame.floatValue(), localPointF1, localPointF2, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
        if (paramKeyframe != null) {
          return paramKeyframe;
        }
      }
      point.set(x + (x - x) * paramFloat, y + paramFloat * (y - y));
      return point;
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}
