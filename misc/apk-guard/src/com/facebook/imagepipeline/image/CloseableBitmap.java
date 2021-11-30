package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;

public abstract class CloseableBitmap
  extends CloseableImage
{
  public CloseableBitmap() {}
  
  public abstract Bitmap getUnderlyingBitmap();
}
