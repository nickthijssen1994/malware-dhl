package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;

public abstract interface BitmapTransformation
{
  public abstract boolean modifiesTransparency();
  
  public abstract void transform(Bitmap paramBitmap);
}
