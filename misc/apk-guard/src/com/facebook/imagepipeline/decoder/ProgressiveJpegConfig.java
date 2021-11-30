package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;

public abstract interface ProgressiveJpegConfig
{
  public abstract int getNextScanNumberToDecode(int paramInt);
  
  public abstract QualityInfo getQualityInfo(int paramInt);
}
