package com.facebook.drawee.backends.pipeline.info;

public abstract interface ImagePerfDataListener
{
  public abstract void onImageLoadStatusUpdated(ImagePerfData paramImagePerfData, int paramInt);
  
  public abstract void onImageVisibilityUpdated(ImagePerfData paramImagePerfData, int paramInt);
}
