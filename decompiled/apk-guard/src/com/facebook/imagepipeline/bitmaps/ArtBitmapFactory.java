package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.Pool;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtBitmapFactory
  extends PlatformBitmapFactory
{
  private final BitmapPool mBitmapPool;
  private final CloseableReferenceFactory mCloseableReferenceFactory;
  
  public ArtBitmapFactory(BitmapPool paramBitmapPool, CloseableReferenceFactory paramCloseableReferenceFactory)
  {
    mBitmapPool = paramBitmapPool;
    mCloseableReferenceFactory = paramCloseableReferenceFactory;
  }
  
  public CloseableReference createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap = (Bitmap)mBitmapPool.get(i);
    boolean bool;
    if (localBitmap.getAllocationByteCount() >= paramInt1 * paramInt2 * BitmapUtil.getPixelSizeForBitmapConfig(paramConfig)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    localBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
    return mCloseableReferenceFactory.create(localBitmap, mBitmapPool);
  }
}
