package com.facebook.imagepipeline.image;

public abstract interface ImageInfo
{
  public abstract int getHeight();
  
  public abstract QualityInfo getQualityInfo();
  
  public abstract int getWidth();
}
