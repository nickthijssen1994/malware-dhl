package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.OutputStream;

public class SimpleImageTranscoder
  implements ImageTranscoder
{
  private static final String PAGE_KEY = "SimpleImageTranscoder";
  private final int mMaxBitmapSize;
  private final boolean mResizingEnabled;
  
  public SimpleImageTranscoder(boolean paramBoolean, int paramInt)
  {
    mResizingEnabled = paramBoolean;
    mMaxBitmapSize = paramInt;
  }
  
  private static Bitmap.CompressFormat getOutputFormat(ImageFormat paramImageFormat)
  {
    if (paramImageFormat == null) {
      return Bitmap.CompressFormat.JPEG;
    }
    if (paramImageFormat == DefaultImageFormats.JPEG) {
      return Bitmap.CompressFormat.JPEG;
    }
    if (paramImageFormat == DefaultImageFormats.PNG) {
      return Bitmap.CompressFormat.PNG;
    }
    if ((Build.VERSION.SDK_INT >= 14) && (DefaultImageFormats.isStaticWebpFormat(paramImageFormat))) {
      return Bitmap.CompressFormat.WEBP;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  private int getSampleSize(EncodedImage paramEncodedImage, RotationOptions paramRotationOptions, ResizeOptions paramResizeOptions)
  {
    if (!mResizingEnabled) {
      return 1;
    }
    return DownsampleUtil.determineSampleSize(paramRotationOptions, paramResizeOptions, paramEncodedImage, mMaxBitmapSize);
  }
  
  public boolean canResize(EncodedImage paramEncodedImage, RotationOptions paramRotationOptions, ResizeOptions paramResizeOptions)
  {
    RotationOptions localRotationOptions = paramRotationOptions;
    if (paramRotationOptions == null) {
      localRotationOptions = RotationOptions.autoRotate();
    }
    return (mResizingEnabled) && (DownsampleUtil.determineSampleSize(localRotationOptions, paramResizeOptions, paramEncodedImage, mMaxBitmapSize) > 1);
  }
  
  public boolean canTranscode(ImageFormat paramImageFormat)
  {
    return (paramImageFormat == DefaultImageFormats.HEIF) || (paramImageFormat == DefaultImageFormats.JPEG);
  }
  
  public String getIdentifier()
  {
    return "SimpleImageTranscoder";
  }
  
  public ImageTranscodeResult transcode(EncodedImage paramEncodedImage, OutputStream paramOutputStream, RotationOptions paramRotationOptions, ResizeOptions paramResizeOptions, ImageFormat paramImageFormat, Integer paramInteger)
  {
    Integer localInteger = paramInteger;
    if (paramInteger == null) {
      localInteger = Integer.valueOf(85);
    }
    paramInteger = paramRotationOptions;
    if (paramRotationOptions == null) {
      paramInteger = RotationOptions.autoRotate();
    }
    int j = getSampleSize(paramEncodedImage, paramInteger, paramResizeOptions);
    paramRotationOptions = new BitmapFactory.Options();
    inSampleSize = j;
    try
    {
      paramRotationOptions = BitmapFactory.decodeStream(paramEncodedImage.getInputStream(), null, paramRotationOptions);
      if (paramRotationOptions == null)
      {
        FLog.e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
        return new ImageTranscodeResult(2);
      }
      paramEncodedImage = JpegTranscoderUtils.getTransformationMatrix(paramEncodedImage, paramInteger);
      if (paramEncodedImage != null) {
        try
        {
          paramEncodedImage = Bitmap.createBitmap(paramRotationOptions, 0, 0, paramRotationOptions.getWidth(), paramRotationOptions.getHeight(), paramEncodedImage, false);
        }
        catch (Throwable paramEncodedImage)
        {
          paramResizeOptions = paramRotationOptions;
          break label227;
        }
        catch (OutOfMemoryError paramOutputStream)
        {
          paramEncodedImage = paramRotationOptions;
          break label194;
        }
      } else {
        paramEncodedImage = paramRotationOptions;
      }
      paramResizeOptions = paramEncodedImage;
      try
      {
        paramEncodedImage.compress(getOutputFormat(paramImageFormat), localInteger.intValue(), paramOutputStream);
        int i = 1;
        if (j > 1) {
          i = 0;
        }
        paramResizeOptions = paramEncodedImage;
        paramOutputStream = new ImageTranscodeResult(i);
        paramEncodedImage.recycle();
        paramRotationOptions.recycle();
        return paramOutputStream;
      }
      catch (Throwable paramEncodedImage) {}catch (OutOfMemoryError paramOutputStream) {}
      label194:
      paramResizeOptions = paramEncodedImage;
      FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", paramOutputStream);
      paramResizeOptions = paramEncodedImage;
      paramOutputStream = new ImageTranscodeResult(2);
      paramEncodedImage.recycle();
      paramRotationOptions.recycle();
      return paramOutputStream;
    }
    catch (OutOfMemoryError paramEncodedImage)
    {
      label227:
      FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", paramEncodedImage);
    }
    paramResizeOptions.recycle();
    paramRotationOptions.recycle();
    throw paramEncodedImage;
    return new ImageTranscodeResult(2);
  }
}
