package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import java.lang.reflect.Constructor;

public class AnimatedFactoryProvider
{
  private static AnimatedFactory sImpl;
  private static boolean sImplLoaded;
  
  public AnimatedFactoryProvider() {}
  
  public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory paramPlatformBitmapFactory, ExecutorSupplier paramExecutorSupplier, CountingMemoryCache paramCountingMemoryCache, boolean paramBoolean)
  {
    if (!sImplLoaded) {}
    try
    {
      sImpl = (AnimatedFactory)Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(new Class[] { PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE }).newInstance(new Object[] { paramPlatformBitmapFactory, paramExecutorSupplier, paramCountingMemoryCache, Boolean.valueOf(paramBoolean) });
      if (sImpl != null) {
        sImplLoaded = true;
      }
      return sImpl;
    }
    catch (Throwable paramPlatformBitmapFactory)
    {
      for (;;) {}
    }
  }
}
