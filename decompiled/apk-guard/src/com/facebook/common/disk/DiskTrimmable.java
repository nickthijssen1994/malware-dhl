package com.facebook.common.disk;

public abstract interface DiskTrimmable
{
  public abstract void trimToMinimum();
  
  public abstract void trimToNothing();
}
