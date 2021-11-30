package com.facebook.common.memory;

public abstract interface MemoryTrimmableRegistry
{
  public abstract void registerMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);
  
  public abstract void unregisterMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);
}
