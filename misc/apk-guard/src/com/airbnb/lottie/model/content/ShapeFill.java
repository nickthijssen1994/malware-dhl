package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeFill
  implements ContentModel
{
  @Nullable
  private final AnimatableColorValue color;
  private final boolean fillEnabled;
  private final Path.FillType fillType;
  private final boolean hidden;
  private final String name;
  @Nullable
  private final AnimatableIntegerValue opacity;
  
  public ShapeFill(String paramString, boolean paramBoolean1, Path.FillType paramFillType, AnimatableColorValue paramAnimatableColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, boolean paramBoolean2)
  {
    name = paramString;
    fillEnabled = paramBoolean1;
    fillType = paramFillType;
    color = paramAnimatableColorValue;
    opacity = paramAnimatableIntegerValue;
    hidden = paramBoolean2;
  }
  
  public AnimatableColorValue getColor()
  {
    return color;
  }
  
  public Path.FillType getFillType()
  {
    return fillType;
  }
  
  public String getName()
  {
    return name;
  }
  
  public AnimatableIntegerValue getOpacity()
  {
    return opacity;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new FillContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeFill{color=, fillEnabled=");
    localStringBuilder.append(fillEnabled);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
