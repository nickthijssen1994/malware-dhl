package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation
  extends KeyframeAnimation<ScaleXY>
{
  private final ScaleXY scaleXY = new ScaleXY();
  
  public ScaleKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  public ScaleXY getValue(Keyframe paramKeyframe, float paramFloat)
  {
    if ((startValue != null) && (endValue != null))
    {
      ScaleXY localScaleXY1 = (ScaleXY)startValue;
      ScaleXY localScaleXY2 = (ScaleXY)endValue;
      if (valueCallback != null)
      {
        paramKeyframe = (ScaleXY)valueCallback.getValueInternal(startFrame, endFrame.floatValue(), localScaleXY1, localScaleXY2, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
        if (paramKeyframe != null) {
          return paramKeyframe;
        }
      }
      scaleXY.set(MiscUtils.lerp(localScaleXY1.getScaleX(), localScaleXY2.getScaleX(), paramFloat), MiscUtils.lerp(localScaleXY1.getScaleY(), localScaleXY2.getScaleY(), paramFloat));
      return scaleXY;
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}
