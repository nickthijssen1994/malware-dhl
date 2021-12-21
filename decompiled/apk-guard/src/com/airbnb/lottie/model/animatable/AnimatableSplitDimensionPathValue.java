package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import java.util.List;

public class AnimatableSplitDimensionPathValue
  implements AnimatableValue<PointF, PointF>
{
  private final AnimatableFloatValue animatableXDimension;
  private final AnimatableFloatValue animatableYDimension;
  
  public AnimatableSplitDimensionPathValue(AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2)
  {
    animatableXDimension = paramAnimatableFloatValue1;
    animatableYDimension = paramAnimatableFloatValue2;
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    return new SplitDimensionPathKeyframeAnimation(animatableXDimension.createAnimation(), animatableYDimension.createAnimation());
  }
  
  public List getKeyframes()
  {
    throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
  }
  
  public boolean isStatic()
  {
    return (animatableXDimension.isStatic()) && (animatableYDimension.isStatic());
  }
}
