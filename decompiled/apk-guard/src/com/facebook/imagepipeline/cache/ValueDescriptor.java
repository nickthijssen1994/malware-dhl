package com.facebook.imagepipeline.cache;

public abstract interface ValueDescriptor<V>
{
  public abstract int getSizeInBytes(Object paramObject);
}
