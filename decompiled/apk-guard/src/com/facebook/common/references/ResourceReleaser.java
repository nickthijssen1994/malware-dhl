package com.facebook.common.references;

public abstract interface ResourceReleaser<T>
{
  public abstract void release(Object paramObject);
}
