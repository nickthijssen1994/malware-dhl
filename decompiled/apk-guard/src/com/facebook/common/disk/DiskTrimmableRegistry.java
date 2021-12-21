package com.facebook.common.disk;

public abstract interface DiskTrimmableRegistry
{
  public abstract void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable);
  
  public abstract void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable);
}
