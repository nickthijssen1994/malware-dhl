package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class GradientFill
  implements ContentModel
{
  private final AnimatablePointValue endPoint;
  private final Path.FillType fillType;
  private final AnimatableGradientColorValue gradientColor;
  private final GradientType gradientType;
  private final boolean hidden;
  @Nullable
  private final AnimatableFloatValue highlightAngle;
  @Nullable
  private final AnimatableFloatValue highlightLength;
  private final String name;
  private final AnimatableIntegerValue opacity;
  private final AnimatablePointValue startPoint;
  
  public GradientFill(String paramString, GradientType paramGradientType, Path.FillType paramFillType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, boolean paramBoolean)
  {
    gradientType = paramGradientType;
    fillType = paramFillType;
    gradientColor = paramAnimatableGradientColorValue;
    opacity = paramAnimatableIntegerValue;
    startPoint = paramAnimatablePointValue1;
    endPoint = paramAnimatablePointValue2;
    name = paramString;
    highlightLength = paramAnimatableFloatValue1;
    highlightAngle = paramAnimatableFloatValue2;
    hidden = paramBoolean;
  }
  
  public AnimatablePointValue getEndPoint()
  {
    return endPoint;
  }
  
  public Path.FillType getFillType()
  {
    return fillType;
  }
  
  public AnimatableGradientColorValue getGradientColor()
  {
    return gradientColor;
  }
  
  public GradientType getGradientType()
  {
    return gradientType;
  }
  
  AnimatableFloatValue getHighlightAngle()
  {
    return highlightAngle;
  }
  
  AnimatableFloatValue getHighlightLength()
  {
    return highlightLength;
  }
  
  public String getName()
  {
    return name;
  }
  
  public AnimatableIntegerValue getOpacity()
  {
    return opacity;
  }
  
  public AnimatablePointValue getStartPoint()
  {
    return startPoint;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new GradientFillContent(paramLottieDrawable, paramBaseLayer, this);
  }
}
