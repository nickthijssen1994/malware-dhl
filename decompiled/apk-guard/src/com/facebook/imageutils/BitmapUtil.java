package com.facebook.imageutils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class BitmapUtil
{
  public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
  public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
  public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
  private static final Pools.SynchronizedPool<ByteBuffer> DECODE_BUFFERS = new Pools.SynchronizedPool(12);
  private static final int DECODE_BUFFER_SIZE = 16384;
  public static final float MAX_BITMAP_SIZE = 2048.0F;
  private static final int POOL_SIZE = 12;
  public static final int RGBA_F16_BYTES_PER_PIXEL = 8;
  public static final int RGB_565_BYTES_PER_PIXEL = 2;
  
  public BitmapUtil() {}
  
  public static Pair decodeDimensions(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramUri.getPath(), localOptions);
    if ((outWidth != -1) && (outHeight != -1)) {
      return new Pair(Integer.valueOf(outWidth), Integer.valueOf(outHeight));
    }
    return null;
  }
  
  public static Pair decodeDimensions(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream);
    ByteBuffer localByteBuffer2 = (ByteBuffer)DECODE_BUFFERS.acquire();
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null) {
      localByteBuffer1 = ByteBuffer.allocate(16384);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    try
    {
      inTempStorage = localByteBuffer1.array();
      localByteBuffer2 = null;
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      int i = outWidth;
      paramInputStream = localByteBuffer2;
      if (i != -1)
      {
        i = outHeight;
        if (i == -1) {
          paramInputStream = localByteBuffer2;
        } else {
          paramInputStream = new Pair(Integer.valueOf(outWidth), Integer.valueOf(outHeight));
        }
      }
      DECODE_BUFFERS.release(localByteBuffer1);
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      DECODE_BUFFERS.release(localByteBuffer1);
      throw paramInputStream;
    }
  }
  
  public static Pair decodeDimensions(byte[] paramArrayOfByte)
  {
    return decodeDimensions(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static ImageMetaData decodeDimensionsAndColorSpace(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream);
    ByteBuffer localByteBuffer2 = (ByteBuffer)DECODE_BUFFERS.acquire();
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null) {
      localByteBuffer1 = ByteBuffer.allocate(16384);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    try
    {
      inTempStorage = localByteBuffer1.array();
      localByteBuffer2 = null;
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      int i = Build.VERSION.SDK_INT;
      paramInputStream = localByteBuffer2;
      if (i >= 26) {
        paramInputStream = outColorSpace;
      }
      paramInputStream = new ImageMetaData(outWidth, outHeight, paramInputStream);
      DECODE_BUFFERS.release(localByteBuffer1);
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      DECODE_BUFFERS.release(localByteBuffer1);
      throw paramInputStream;
    }
  }
  
  public static int getPixelSizeForBitmapConfig(Bitmap.Config paramConfig)
  {
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    default: 
      throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    case 5: 
      return 8;
    case 3: 
    case 4: 
      return 2;
    case 2: 
      return 1;
    }
    return 4;
  }
  
  public static int getSizeInByteForBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * getPixelSizeForBitmapConfig(paramConfig);
  }
  
  public static int getSizeInBytes(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT > 19) {}
    try
    {
      int i = paramBitmap.getAllocationByteCount();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}
