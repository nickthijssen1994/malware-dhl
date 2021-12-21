package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe
  extends Keyframe<PointF>
{
  @Nullable
  private Path path;
  private final Keyframe<PointF> pointKeyFrame;
  
  public PathKeyframe(LottieComposition paramLottieComposition, Keyframe paramKeyframe)
  {
    super(paramLottieComposition, startValue, endValue, interpolator, startFrame, endFrame);
    pointKeyFrame = paramKeyframe;
    createPath();
  }
  
  public void createPath()
  {
    int i;
    if ((endValue != null) && (startValue != null) && (((PointF)startValue).equals(endValue).x, endValue).y))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((endValue != null) && (i == 0)) {
      path = Utils.createPath((PointF)startValue, (PointF)endValue, pointKeyFrame.pathCp1, pointKeyFrame.pathCp2);
    }
  }
  
  Path getPath()
  {
    return path;
  }
}
