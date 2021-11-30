package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class GradientStroke
  implements ContentModel
{
  private final ShapeStroke.LineCapType capType;
  @Nullable
  private final AnimatableFloatValue dashOffset;
  private final AnimatablePointValue endPoint;
  private final AnimatableGradientColorValue gradientColor;
  private final GradientType gradientType;
  private final boolean hidden;
  private final ShapeStroke.LineJoinType joinType;
  private final List<AnimatableFloatValue> lineDashPattern;
  private final float miterLimit;
  private final String name;
  private final AnimatableIntegerValue opacity;
  private final AnimatablePointValue startPoint;
  private final AnimatableFloatValue width;
  
  public GradientStroke(String paramString, GradientType paramGradientType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, ShapeStroke.LineCapType paramLineCapType, ShapeStroke.LineJoinType paramLineJoinType, float paramFloat, List paramList, AnimatableFloatValue paramAnimatableFloatValue2, boolean paramBoolean)
  {
    name = paramString;
    gradientType = paramGradientType;
    gradientColor = paramAnimatableGradientColorValue;
    opacity = paramAnimatableIntegerValue;
    startPoint = paramAnimatablePointValue1;
    endPoint = paramAnimatablePointValue2;
    width = paramAnimatableFloatValue1;
    capType = paramLineCapType;
    joinType = paramLineJoinType;
    miterLimit = paramFloat;
    lineDashPattern = paramList;
    dashOffset = paramAnimatableFloatValue2;
    hidden = paramBoolean;
  }
  
  public ShapeStroke.LineCapType getCapType()
  {
    return capType;
  }
  
  public AnimatableFloatValue getDashOffset()
  {
    return dashOffset;
  }
  
  public AnimatablePointValue getEndPoint()
  {
    return endPoint;
  }
  
  public AnimatableGradientColorValue getGradientColor()
  {
    return gradientColor;
  }
  
  public GradientType getGradientType()
  {
    return gradientType;
  }
  
  public ShapeStroke.LineJoinType getJoinType()
  {
    return joinType;
  }
  
  public List getLineDashPattern()
  {
    return lineDashPattern;
  }
  
  public float getMiterLimit()
  {
    return miterLimit;
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
  
  public AnimatableFloatValue getWidth()
  {
    return width;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new GradientStrokeContent(paramLottieDrawable, paramBaseLayer, this);
  }
}
