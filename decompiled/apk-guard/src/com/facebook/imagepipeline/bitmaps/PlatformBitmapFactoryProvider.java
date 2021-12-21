package com.facebook.imagepipeline.bitmaps;

import android.os.Build.VERSION;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;

public class PlatformBitmapFactoryProvider
{
  public PlatformBitmapFactoryProvider() {}
  
  public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory paramPoolFactory, PlatformDecoder paramPlatformDecoder, CloseableReferenceFactory paramCloseableReferenceFactory)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ArtBitmapFactory(paramPoolFactory.getBitmapPool(), paramCloseableReferenceFactory);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new HoneycombBitmapFactory(new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory()), paramPlatformDecoder, paramCloseableReferenceFactory);
    }
    return new GingerbreadBitmapFactory();
  }
}
