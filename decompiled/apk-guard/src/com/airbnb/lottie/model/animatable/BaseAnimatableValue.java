package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O>
  implements AnimatableValue<V, O>
{
  final List<Keyframe<V>> keyframes;
  
  BaseAnimatableValue(Object paramObject)
  {
    this(Collections.singletonList(new Keyframe(paramObject)));
  }
  
  BaseAnimatableValue(List paramList)
  {
    keyframes = paramList;
  }
  
  public List getKeyframes()
  {
    return keyframes;
  }
  
  public boolean isStatic()
  {
    return (keyframes.isEmpty()) || ((keyframes.size() == 1) && (((Keyframe)keyframes.get(0)).isStatic()));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!keyframes.isEmpty())
    {
      localStringBuilder.append("values=");
      localStringBuilder.append(Arrays.toString(keyframes.toArray()));
    }
    return localStringBuilder.toString();
  }
}
