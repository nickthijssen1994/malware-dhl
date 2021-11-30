package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class CircleShape
  implements ContentModel
{
  private final boolean hidden;
  private final boolean isReversed;
  private final String name;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatablePointValue size;
  
  public CircleShape(String paramString, AnimatableValue paramAnimatableValue, AnimatablePointValue paramAnimatablePointValue, boolean paramBoolean1, boolean paramBoolean2)
  {
    name = paramString;
    position = paramAnimatableValue;
    size = paramAnimatablePointValue;
    isReversed = paramBoolean1;
    hidden = paramBoolean2;
  }
  
  public String getName()
  {
    return name;
  }
  
  public AnimatableValue getPosition()
  {
    return position;
  }
  
  public AnimatablePointValue getSize()
  {
    return size;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public boolean isReversed()
  {
    return isReversed;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new EllipseContent(paramLottieDrawable, paramBaseLayer, this);
  }
}
