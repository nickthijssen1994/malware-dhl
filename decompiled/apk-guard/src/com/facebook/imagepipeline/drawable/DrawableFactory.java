package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;

public abstract interface DrawableFactory
{
  public abstract Drawable createDrawable(CloseableImage paramCloseableImage);
  
  public abstract boolean supportsImageType(CloseableImage paramCloseableImage);
}
