package com.facebook.cache.common;

import javax.annotation.Nullable;

public class NoOpCacheErrorLogger
  implements CacheErrorLogger
{
  @Nullable
  private static NoOpCacheErrorLogger sInstance;
  
  private NoOpCacheErrorLogger() {}
  
  public static NoOpCacheErrorLogger getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpCacheErrorLogger();
      }
      NoOpCacheErrorLogger localNoOpCacheErrorLogger = sInstance;
      return localNoOpCacheErrorLogger;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void logError(CacheErrorLogger.CacheErrorCategory paramCacheErrorCategory, Class paramClass, String paramString, Throwable paramThrowable) {}
}
