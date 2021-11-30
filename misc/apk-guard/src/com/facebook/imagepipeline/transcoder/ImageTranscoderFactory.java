package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;

public abstract interface ImageTranscoderFactory
{
  public abstract ImageTranscoder createImageTranscoder(ImageFormat paramImageFormat, boolean paramBoolean);
}
