package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class BlurPostProcessor
  extends BasePostprocessor
{
  private static final int DEFAULT_ITERATIONS = 3;
  private static final boolean canUseRenderScript = ;
  private final int mBlurRadius;
  private CacheKey mCacheKey;
  private final Context mContext;
  private final int mIterations;
  
  public BlurPostProcessor(int paramInt, Context paramContext)
  {
    this(paramInt, paramContext, 3);
  }
  
  public BlurPostProcessor(int paramInt1, Context paramContext, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 > 0) && (paramInt1 <= 25)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt2 > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    Preconditions.checkNotNull(paramContext);
    mIterations = paramInt2;
    mBlurRadius = paramInt1;
    mContext = paramContext;
  }
  
  public CacheKey getPostprocessorCacheKey()
  {
    if (mCacheKey == null)
    {
      String str;
      if (canUseRenderScript) {
        str = String.format(null, "IntrinsicBlur;%d", new Object[] { Integer.valueOf(mBlurRadius) });
      } else {
        str = String.format(null, "IterativeBoxBlur;%d;%d", new Object[] { Integer.valueOf(mIterations), Integer.valueOf(mBlurRadius) });
      }
      mCacheKey = new SimpleCacheKey(str);
    }
    return mCacheKey;
  }
  
  public void process(Bitmap paramBitmap)
  {
    IterativeBoxBlurFilter.boxBlurBitmapInPlace(paramBitmap, mIterations, mBlurRadius);
  }
  
  public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (canUseRenderScript)
    {
      RenderScriptBlurFilter.blurBitmap(paramBitmap1, paramBitmap2, mContext, mBlurRadius);
      return;
    }
    super.process(paramBitmap1, paramBitmap2);
  }
}
