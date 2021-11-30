package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue
  implements AnimatableValue<PointF, PointF>
{
  private final List<Keyframe<PointF>> keyframes;
  
  public AnimatablePathValue()
  {
    keyframes = Collections.singletonList(new Keyframe(new PointF(0.0F, 0.0F)));
  }
  
  public AnimatablePathValue(List paramList)
  {
    keyframes = paramList;
  }
  
  public BaseKeyframeAnimation createAnimation()
  {
    if (((Keyframe)keyframes.get(0)).isStatic()) {
      return new PointKeyframeAnimation(keyframes);
    }
    return new PathKeyframeAnimation(keyframes);
  }
  
  public List getKeyframes()
  {
    return keyframes;
  }
  
  public boolean isStatic()
  {
    return (keyframes.size() == 1) && (((Keyframe)keyframes.get(0)).isStatic());
  }
}
