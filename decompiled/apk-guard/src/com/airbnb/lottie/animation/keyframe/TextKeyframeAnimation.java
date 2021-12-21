package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class TextKeyframeAnimation
  extends KeyframeAnimation<DocumentData>
{
  public TextKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  DocumentData getValue(Keyframe paramKeyframe, float paramFloat)
  {
    return (DocumentData)startValue;
  }
}
