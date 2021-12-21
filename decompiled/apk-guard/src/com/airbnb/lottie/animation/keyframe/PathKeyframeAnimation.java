package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PathKeyframeAnimation
  extends KeyframeAnimation<PointF>
{
  private final float[] coords = new float[2];
  private PathMeasure pathMeasure = new PathMeasure();
  private PathKeyframe pathMeasureKeyframe;
  private final PointF point = new PointF();
  
  public PathKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  public PointF getValue(Keyframe paramKeyframe, float paramFloat)
  {
    Object localObject = (PathKeyframe)paramKeyframe;
    Path localPath = ((PathKeyframe)localObject).getPath();
    if (localPath == null) {
      return (PointF)startValue;
    }
    if (valueCallback != null)
    {
      paramKeyframe = (PointF)valueCallback.getValueInternal(startFrame, endFrame.floatValue(), startValue, endValue, getLinearCurrentKeyframeProgress(), paramFloat, getProgress());
      if (paramKeyframe != null) {
        return paramKeyframe;
      }
    }
    if (pathMeasureKeyframe != localObject)
    {
      pathMeasure.setPath(localPath, false);
      pathMeasureKeyframe = ((PathKeyframe)localObject);
    }
    paramKeyframe = pathMeasure;
    paramKeyframe.getPosTan(paramFloat * paramKeyframe.getLength(), coords, null);
    paramKeyframe = point;
    localObject = coords;
    paramKeyframe.set(localObject[0], localObject[1]);
    return point;
  }
}
