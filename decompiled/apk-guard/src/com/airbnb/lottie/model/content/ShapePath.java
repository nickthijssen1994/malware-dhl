package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapePath
  implements ContentModel
{
  private final boolean hidden;
  private final int index;
  private final String name;
  private final AnimatableShapeValue shapePath;
  
  public ShapePath(String paramString, int paramInt, AnimatableShapeValue paramAnimatableShapeValue, boolean paramBoolean)
  {
    name = paramString;
    index = paramInt;
    shapePath = paramAnimatableShapeValue;
    hidden = paramBoolean;
  }
  
  public String getName()
  {
    return name;
  }
  
  public AnimatableShapeValue getShapePath()
  {
    return shapePath;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new ShapeContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapePath{name=");
    localStringBuilder.append(name);
    localStringBuilder.append(", index=");
    localStringBuilder.append(index);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
