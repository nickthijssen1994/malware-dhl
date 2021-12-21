package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

public abstract interface CacheKeyFactory
{
  public abstract CacheKey getBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject);
  
  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, Uri paramUri, Object paramObject);
  
  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, Object paramObject);
  
  public abstract CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject);
}
