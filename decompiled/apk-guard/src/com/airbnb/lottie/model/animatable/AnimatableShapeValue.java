package com.airbnb.lottie.model.animatable;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class AnimatableShapeValue
  extends BaseAnimatableValue<ShapeData, Path>
{
  public AnimatableShapeValue(List paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new ShapeKeyframeAnimation(keyframes);
  }
}
