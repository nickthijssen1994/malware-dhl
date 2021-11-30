package com.facebook.imagepipeline.memory;

abstract interface PoolBackend<T>
{
  public abstract Object get(int paramInt);
  
  public abstract int getSize(Object paramObject);
  
  public abstract void put(Object paramObject);
  
  public abstract Object putIfAbsent();
}
