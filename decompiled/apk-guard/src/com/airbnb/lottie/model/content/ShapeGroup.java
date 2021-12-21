package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup
  implements ContentModel
{
  private final boolean hidden;
  private final List<ContentModel> items;
  private final String name;
  
  public ShapeGroup(String paramString, List paramList, boolean paramBoolean)
  {
    name = paramString;
    items = paramList;
    hidden = paramBoolean;
  }
  
  public List getItems()
  {
    return items;
  }
  
  public String getName()
  {
    return name;
  }
  
  public boolean isHidden()
  {
    return hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new ContentGroup(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeGroup{name='");
    localStringBuilder.append(name);
    localStringBuilder.append("' Shapes: ");
    localStringBuilder.append(Arrays.toString(items.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
