package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;

public abstract interface FileCacheFactory
{
  public abstract FileCache getImageUrl(DiskCacheConfig paramDiskCacheConfig);
}
