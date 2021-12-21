package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;

public class DynamicDefaultDiskStorageFactory
  implements DiskStorageFactory
{
  public DynamicDefaultDiskStorageFactory() {}
  
  public DiskStorage createIndex(DiskCacheConfig paramDiskCacheConfig)
  {
    return new DynamicDefaultDiskStorage(paramDiskCacheConfig.getVersion(), paramDiskCacheConfig.getBaseDirectoryPathSupplier(), paramDiskCacheConfig.getBaseDirectoryName(), paramDiskCacheConfig.getCacheErrorLogger());
  }
}
