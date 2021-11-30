package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;

public class ImagePerfImageOriginListener
  implements ImageOriginListener
{
  private final ImagePerfMonitor mImagePerfMonitor;
  private final ImagePerfState mImagePerfState;
  
  public ImagePerfImageOriginListener(ImagePerfState paramImagePerfState, ImagePerfMonitor paramImagePerfMonitor)
  {
    mImagePerfState = paramImagePerfState;
    mImagePerfMonitor = paramImagePerfMonitor;
  }
  
  public void onImageLoaded(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    mImagePerfState.setImageOrigin(paramInt);
    mImagePerfState.setUltimateProducerName(paramString2);
    mImagePerfMonitor.notifyStatusUpdated(mImagePerfState, 1);
  }
}
