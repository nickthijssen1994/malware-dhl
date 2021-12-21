package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;

public abstract interface DiskStorageFactory
{
  public abstract DiskStorage createIndex(DiskCacheConfig paramDiskCacheConfig);
}
