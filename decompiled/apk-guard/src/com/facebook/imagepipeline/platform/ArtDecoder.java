package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtDecoder
  extends DefaultDecoder
{
  public ArtDecoder(BitmapPool paramBitmapPool, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    super(paramBitmapPool, paramInt, paramSynchronizedPool);
  }
  
  public int getBitmapSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    return BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, inPreferredConfig);
  }
}
