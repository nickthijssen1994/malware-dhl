package com.facebook.imagepipeline.cache;

import java.util.concurrent.TimeUnit;

public class MemoryCacheParams
{
  public final int maxCacheEntries;
  public final int maxCacheEntrySize;
  public final int maxCacheSize;
  public final int maxEvictionQueueEntries;
  public final int maxEvictionQueueSize;
  public final long paramsCheckIntervalMs;
  
  public MemoryCacheParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, TimeUnit.MINUTES.toMillis(5L));
  }
  
  public MemoryCacheParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    maxCacheSize = paramInt1;
    maxCacheEntries = paramInt2;
    maxEvictionQueueSize = paramInt3;
    maxEvictionQueueEntries = paramInt4;
    maxCacheEntrySize = paramInt5;
    paramsCheckIntervalMs = paramLong;
  }
}
