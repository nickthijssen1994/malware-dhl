package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;

public class SimpleImageTranscoderFactory
  implements ImageTranscoderFactory
{
  private final int mMaxBitmapSize;
  
  public SimpleImageTranscoderFactory(int paramInt)
  {
    mMaxBitmapSize = paramInt;
  }
  
  public ImageTranscoder createImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean)
  {
    return new SimpleImageTranscoder(paramBoolean, mMaxBitmapSize);
  }
}
