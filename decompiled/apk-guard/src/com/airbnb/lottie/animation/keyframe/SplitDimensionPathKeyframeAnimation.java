package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class SplitDimensionPathKeyframeAnimation
  extends BaseKeyframeAnimation<PointF, PointF>
{
  private final PointF point = new PointF();
  private final BaseKeyframeAnimation<Float, Float> xAnimation;
  private final BaseKeyframeAnimation<Float, Float> yAnimation;
  
  public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation paramBaseKeyframeAnimation1, BaseKeyframeAnimation paramBaseKeyframeAnimation2)
  {
    super(Collections.emptyList());
    xAnimation = paramBaseKeyframeAnimation1;
    yAnimation = paramBaseKeyframeAnimation2;
    setProgress(getProgress());
  }
  
  public PointF getValue()
  {
    return getValue(null, 0.0F);
  }
  
  PointF getValue(Keyframe paramKeyframe, float paramFloat)
  {
    return point;
  }
  
  public void setProgress(float paramFloat)
  {
    xAnimation.setProgress(paramFloat);
    yAnimation.setProgress(paramFloat);
    point.set(((Float)xAnimation.getValue()).floatValue(), ((Float)yAnimation.getValue()).floatValue());
    int i = 0;
    while (i < listeners.size())
    {
      ((BaseKeyframeAnimation.AnimationListener)listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
}
