package com.airbnb.lottie.animation.keyframe;

import java.util.List;

abstract class KeyframeAnimation<T>
  extends BaseKeyframeAnimation<T, T>
{
  KeyframeAnimation(List paramList)
  {
    super(paramList);
  }
}
