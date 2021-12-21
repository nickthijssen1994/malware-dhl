package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;

public class DefaultBitmapMemoryCacheParamsSupplier
  implements Supplier<MemoryCacheParams>
{
  private static final int MAX_CACHE_ENTRIES = 256;
  private static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
  private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
  private static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
  private static final long PARAMS_CHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
  private final ActivityManager mActivityManager;
  
  public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager paramActivityManager)
  {
    mActivityManager = paramActivityManager;
  }
  
  private int getMaxCacheSize()
  {
    int i = Math.min(mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
    if (i < 33554432) {
      return 4194304;
    }
    if (i < 67108864) {
      return 6291456;
    }
    if (Build.VERSION.SDK_INT < 11) {
      return 8388608;
    }
    return i / 4;
  }
  
  public MemoryCacheParams getFolder()
  {
    return new MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, PARAMS_CHECK_INTERVAL_MS);
  }
}
