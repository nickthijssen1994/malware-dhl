package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;

public class EncodedCountingMemoryCacheFactory
{
  public EncodedCountingMemoryCacheFactory() {}
  
  public static CountingMemoryCache cache(Supplier paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
  {
    paramSupplier = new CountingMemoryCache(new ValueDescriptor()new NativeMemoryCacheTrimStrategy
    {
      public int getSizeInBytes(PooledByteBuffer paramAnonymousPooledByteBuffer)
      {
        return paramAnonymousPooledByteBuffer.size();
      }
    }, new NativeMemoryCacheTrimStrategy(), paramSupplier);
    paramMemoryTrimmableRegistry.registerMemoryTrimmable(paramSupplier);
    return paramSupplier;
  }
}
