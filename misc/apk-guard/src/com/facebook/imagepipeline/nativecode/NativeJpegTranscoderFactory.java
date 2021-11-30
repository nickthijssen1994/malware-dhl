package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;

@DoNotStrip
public class NativeJpegTranscoderFactory
  implements ImageTranscoderFactory
{
  private final int mMaxBitmapSize;
  private final boolean mUseDownSamplingRatio;
  
  public NativeJpegTranscoderFactory(int paramInt, boolean paramBoolean)
  {
    mMaxBitmapSize = paramInt;
    mUseDownSamplingRatio = paramBoolean;
  }
  
  public ImageTranscoder createImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    if (paramImageFormat != DefaultImageFormats.JPEG) {
      return null;
    }
    return new NativeJpegTranscoder(paramBoolean, mMaxBitmapSize, mUseDownSamplingRatio);
  }
}
