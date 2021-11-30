package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(26)
@ThreadSafe
public class OreoDecoder
  extends DefaultDecoder
{
  public OreoDecoder(BitmapPool paramBitmapPool, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    super(paramBitmapPool, paramInt, paramSynchronizedPool);
  }
  
  private static boolean hasColorGamutMismatch(BitmapFactory.Options paramOptions)
  {
    return (outColorSpace != null) && (outColorSpace.isWideGamut()) && (inPreferredConfig != Enum.RGBA_F16);
  }
  
  public int getBitmapSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    if (hasColorGamutMismatch(paramOptions)) {
      return paramInt1 * paramInt2 * 8;
    }
    return BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, inPreferredConfig);
  }
}
