package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public abstract interface BitmapCreator
{
  public abstract Bitmap createNakedBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
}
