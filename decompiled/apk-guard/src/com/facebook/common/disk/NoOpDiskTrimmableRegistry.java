package com.facebook.common.disk;

import javax.annotation.Nullable;

public class NoOpDiskTrimmableRegistry
  implements DiskTrimmableRegistry
{
  @Nullable
  private static NoOpDiskTrimmableRegistry sInstance;
  
  private NoOpDiskTrimmableRegistry() {}
  
  public static NoOpDiskTrimmableRegistry getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpDiskTrimmableRegistry();
      }
      NoOpDiskTrimmableRegistry localNoOpDiskTrimmableRegistry = sInstance;
      return localNoOpDiskTrimmableRegistry;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable) {}
  
  public void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable) {}
}
