package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;

public abstract interface ThumbnailProducer<T>
  extends Producer<T>
{
  public abstract boolean canProvideImageForSize(ResizeOptions paramResizeOptions);
}
