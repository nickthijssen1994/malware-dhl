package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent
  implements Content, BaseKeyframeAnimation.AnimationListener
{
  private final BaseKeyframeAnimation<?, Float> endAnimation;
  private final boolean hidden;
  private final List<BaseKeyframeAnimation.AnimationListener> listeners = new ArrayList();
  private final String name;
  private final BaseKeyframeAnimation<?, Float> offsetAnimation;
  private final BaseKeyframeAnimation<?, Float> startAnimation;
  private final ShapeTrimPath.Type type;
  
  public TrimPathContent(BaseLayer paramBaseLayer, ShapeTrimPath paramShapeTrimPath)
  {
    name = paramShapeTrimPath.getName();
    hidden = paramShapeTrimPath.isHidden();
    type = paramShapeTrimPath.getType();
    startAnimation = paramShapeTrimPath.getStart().createAnimation();
    endAnimation = paramShapeTrimPath.getEnd().createAnimation();
    offsetAnimation = paramShapeTrimPath.getOffset().createAnimation();
    paramBaseLayer.addAnimation(startAnimation);
    paramBaseLayer.addAnimation(endAnimation);
    paramBaseLayer.addAnimation(offsetAnimation);
    startAnimation.addUpdateListener(this);
    endAnimation.addUpdateListener(this);
    offsetAnimation.addUpdateListener(this);
  }
  
  void addListener(BaseKeyframeAnimation.AnimationListener paramAnimationListener)
  {
    listeners.add(paramAnimationListener);
  }
  
  public BaseKeyframeAnimation getEnd()
  {
    return endAnimation;
  }
  
  public String getName()
  {
    return name;
  }
  
  public BaseKeyframeAnimation getOffset()
  {
    return offsetAnimation;
  }
  
  public BaseKeyframeAnimation getStart()
  {
    return startAnimation;
  }
  
  ShapeTrimPath.Type getType()
  {
    return type;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public void onValueChanged()
  {
    int i = 0;
    while (i < listeners.size())
    {
      ((BaseKeyframeAnimation.AnimationListener)listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
  
  public void setContents(List paramList1, List paramList2) {}
}
