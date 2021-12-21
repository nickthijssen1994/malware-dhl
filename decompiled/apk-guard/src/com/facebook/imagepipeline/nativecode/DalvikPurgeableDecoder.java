package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.soloader.DoNotOptimize;
import java.util.Locale;

@DoNotStrip
public abstract class DalvikPurgeableDecoder
  implements PlatformDecoder
{
  protected static final byte[] EOF_MARKER = { -1, -39 };
  private final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.getBackgroundHandler();
  
  static {}
  
  protected DalvikPurgeableDecoder() {}
  
  public static boolean endsWithEOI(CloseableReference paramCloseableReference, int paramInt)
  {
    paramCloseableReference = (PooledByteBuffer)paramCloseableReference.get();
    return (paramInt >= 2) && (paramCloseableReference.read(paramInt - 2) == -1) && (paramCloseableReference.read(paramInt - 1) == -39);
  }
  
  public static BitmapFactory.Options getBitmapFactoryOptions(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inDither = true;
    inPreferredConfig = paramConfig;
    inPurgeable = true;
    inInputShareable = true;
    inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11) {
      inMutable = true;
    }
    return localOptions;
  }
  
  private static native void nativePinBitmap(Bitmap paramBitmap);
  
  protected abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference paramCloseableReference, BitmapFactory.Options paramOptions);
  
  public CloseableReference decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect)
  {
    return decodeFromEncodedImageWithColorSpace(paramEncodedImage, paramConfig, paramRect, null);
  }
  
  public CloseableReference decodeFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect, ColorSpace paramColorSpace)
  {
    paramConfig = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    if (Build.VERSION.SDK_INT >= 26) {
      OreoUtils.setColorSpace(paramConfig, paramColorSpace);
    }
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      paramConfig = pinBitmap(decodeByteArrayAsPurgeable(paramEncodedImage, paramConfig));
      CloseableReference.closeSafely(paramEncodedImage);
      return paramConfig;
    }
    catch (Throwable paramConfig)
    {
      CloseableReference.closeSafely(paramEncodedImage);
      throw paramConfig;
    }
  }
  
  protected abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions);
  
  public CloseableReference decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect, int paramInt)
  {
    return decodeJPEGFromEncodedImageWithColorSpace(paramEncodedImage, paramConfig, paramRect, paramInt, null);
  }
  
  public CloseableReference decodeJPEGFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect, int paramInt, ColorSpace paramColorSpace)
  {
    paramConfig = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    if (Build.VERSION.SDK_INT >= 26) {
      OreoUtils.setColorSpace(paramConfig, paramColorSpace);
    }
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      paramConfig = pinBitmap(decodeJPEGByteArrayAsPurgeable(paramEncodedImage, paramInt, paramConfig));
      CloseableReference.closeSafely(paramEncodedImage);
      return paramConfig;
    }
    catch (Throwable paramConfig)
    {
      CloseableReference.closeSafely(paramEncodedImage);
      throw paramConfig;
    }
  }
  
  public CloseableReference pinBitmap(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    try
    {
      nativePinBitmap(paramBitmap);
      if (mUnpooledBitmapsCounter.increase(paramBitmap)) {
        return CloseableReference.of(paramBitmap, mUnpooledBitmapsCounter.getReleaser());
      }
      int i = BitmapUtil.getSizeInBytes(paramBitmap);
      paramBitmap.recycle();
      throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", new Object[] { Integer.valueOf(i), Integer.valueOf(mUnpooledBitmapsCounter.getCount()), Long.valueOf(mUnpooledBitmapsCounter.getSize()), Integer.valueOf(mUnpooledBitmapsCounter.getMaxCount()), Integer.valueOf(mUnpooledBitmapsCounter.getMaxSize()) }));
    }
    catch (Exception localException)
    {
      paramBitmap.recycle();
      throw Throwables.propagate(localException);
    }
  }
  
  @DoNotOptimize
  private static class OreoUtils
  {
    private OreoUtils() {}
    
    static void setColorSpace(BitmapFactory.Options paramOptions, ColorSpace paramColorSpace)
    {
      ColorSpace localColorSpace = paramColorSpace;
      if (paramColorSpace == null) {
        localColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
      }
      inPreferredColorSpace = localColorSpace;
    }
  }
}
