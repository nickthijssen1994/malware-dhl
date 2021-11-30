package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class IntegerKeyframeAnimation
  extends KeyframeAnimation<Integer>
{
  public IntegerKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  public int getIntValue()
  {
    return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
  }
  
  int getIntValue(Keyframe paramKeyframe, float paramFloat)
  {
    if ((startValue != null) && (endValue != null))
    {
      if (valueCallback != null)
      {
        Integer localInteger = (Integer)valueCallback.getValueInternal(startFrame, endFrame.floatValue(), startValue, endValue, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
        if (localInteger != null) {
          return localInteger.intValue();
        }
      }
      return MiscUtils.lerp(paramKeyframe.getStartValueInt(), paramKeyframe.getEndValueInt(), paramFloat);
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  Integer getValue(Keyframe paramKeyframe, float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramKeyframe, paramFloat));
  }
}
