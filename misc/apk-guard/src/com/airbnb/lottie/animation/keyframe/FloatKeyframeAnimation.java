package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation
  extends KeyframeAnimation<Float>
{
  public FloatKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  public float getFloatValue()
  {
    return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
  }
  
  float getFloatValue(Keyframe paramKeyframe, float paramFloat)
  {
    if ((startValue != null) && (endValue != null))
    {
      if (valueCallback != null)
      {
        Float localFloat = (Float)valueCallback.getValueInternal(startFrame, endFrame.floatValue(), startValue, endValue, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
        if (localFloat != null) {
          return localFloat.floatValue();
        }
      }
      return MiscUtils.lerp(paramKeyframe.getStartValueFloat(), paramKeyframe.getEndValueFloat(), paramFloat);
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  Float getValue(Keyframe paramKeyframe, float paramFloat)
  {
    return Float.valueOf(getFloatValue(paramKeyframe, paramFloat));
  }
}
