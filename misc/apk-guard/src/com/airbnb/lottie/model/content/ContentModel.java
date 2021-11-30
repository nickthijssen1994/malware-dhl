package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.BaseLayer;

public abstract interface ContentModel
{
  public abstract Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer);
}
