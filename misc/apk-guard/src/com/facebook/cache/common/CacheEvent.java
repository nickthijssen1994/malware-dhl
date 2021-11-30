package com.facebook.cache.common;

import java.io.IOException;

public abstract interface CacheEvent
{
  public abstract CacheKey getCacheKey();
  
  public abstract long getCacheLimit();
  
  public abstract long getCacheSize();
  
  public abstract CacheEventListener.EvictionReason getEvictionReason();
  
  public abstract IOException getException();
  
  public abstract long getItemSize();
  
  public abstract String getResourceId();
}
