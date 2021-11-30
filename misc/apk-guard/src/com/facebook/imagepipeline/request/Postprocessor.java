package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

public abstract interface Postprocessor
{
  public abstract String getName();
  
  public abstract CacheKey getPostprocessorCacheKey();
  
  public abstract CloseableReference process(Bitmap paramBitmap, PlatformBitmapFactory paramPlatformBitmapFactory);
}
