package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation
{
  private final List<BaseKeyframeAnimation<ShapeData, Path>> maskAnimations;
  private final List<Mask> masks;
  private final List<BaseKeyframeAnimation<Integer, Integer>> opacityAnimations;
  
  public MaskKeyframeAnimation(List paramList)
  {
    masks = paramList;
    maskAnimations = new ArrayList(paramList.size());
    opacityAnimations = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      maskAnimations.add(((Mask)paramList.get(i)).getMaskPath().createAnimation());
      AnimatableIntegerValue localAnimatableIntegerValue = ((Mask)paramList.get(i)).getOpacity();
      opacityAnimations.add(localAnimatableIntegerValue.createAnimation());
      i += 1;
    }
  }
  
  public List getMaskAnimations()
  {
    return maskAnimations;
  }
  
  public List getMasks()
  {
    return masks;
  }
  
  public List getOpacityAnimations()
  {
    return opacityAnimations;
  }
}
