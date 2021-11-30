package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class RectangleShape
  implements ContentModel
{
  private final AnimatableFloatValue cornerRadius;
  private final boolean hidden;
  private final String name;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatablePointValue size;
  
  public RectangleShape(String paramString, AnimatableValue paramAnimatableValue, AnimatablePointValue paramAnimatablePointValue, AnimatableFloatValue paramAnimatableFloatValue, boolean paramBoolean)
  {
    name = paramString;
    position = paramAnimatableValue;
    size = paramAnimatablePointValue;
    cornerRadius = paramAnimatableFloatValue;
    hidden = paramBoolean;
  }
  
  public AnimatableFloatValue getCornerRadius()
  {
    return cornerRadius;
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
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new RectangleContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RectangleShape{position=");
    localStringBuilder.append(position);
    localStringBuilder.append(", size=");
    localStringBuilder.append(size);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
