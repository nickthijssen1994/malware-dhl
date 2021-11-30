package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

public class Repeater
  implements ContentModel
{
  private final AnimatableFloatValue copies;
  private final boolean hidden;
  private final String name;
  private final AnimatableFloatValue offset;
  private final AnimatableTransform transform;
  
  public Repeater(String paramString, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableTransform paramAnimatableTransform, boolean paramBoolean)
  {
    name = paramString;
    copies = paramAnimatableFloatValue1;
    offset = paramAnimatableFloatValue2;
    transform = paramAnimatableTransform;
    hidden = paramBoolean;
  }
  
  public AnimatableFloatValue getCopies()
  {
    return copies;
  }
  
  public String getName()
  {
    return name;
  }
  
  public AnimatableFloatValue getOffset()
  {
    return offset;
  }
  
  public AnimatableTransform getTransform()
  {
    return transform;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new RepeaterContent(paramLottieDrawable, paramBaseLayer, this);
  }
}
