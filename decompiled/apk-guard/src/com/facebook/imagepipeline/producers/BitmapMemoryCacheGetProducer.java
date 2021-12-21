package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;

public class BitmapMemoryCacheGetProducer
  extends BitmapMemoryCacheProducer
{
  public static final String PRODUCER_NAME = "BitmapMemoryCacheGetProducer";
  
  public BitmapMemoryCacheGetProducer(MemoryCache paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer paramProducer)
  {
    super(paramMemoryCache, paramCacheKeyFactory, paramProducer);
  }
  
  protected String getProducerName()
  {
    return "BitmapMemoryCacheGetProducer";
  }
  
  protected Consumer wrapConsumer(Consumer paramConsumer, CacheKey paramCacheKey, boolean paramBoolean)
  {
    return paramConsumer;
  }
}
