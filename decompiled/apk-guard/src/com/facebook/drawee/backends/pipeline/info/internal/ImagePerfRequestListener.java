package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

public class ImagePerfRequestListener
  extends BaseRequestListener
{
  private final MonotonicClock mClock;
  private final ImagePerfState mImagePerfState;
  
  public ImagePerfRequestListener(MonotonicClock paramMonotonicClock, ImagePerfState paramImagePerfState)
  {
    mClock = paramMonotonicClock;
    mImagePerfState = paramImagePerfState;
  }
  
  public void onRequestCancellation(String paramString)
  {
    mImagePerfState.setImageRequestEndTimeMs(mClock.now());
    mImagePerfState.setRequestId(paramString);
  }
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    mImagePerfState.setImageRequestEndTimeMs(mClock.now());
    mImagePerfState.setImageRequest(paramImageRequest);
    mImagePerfState.setRequestId(paramString);
    mImagePerfState.setPrefetch(paramBoolean);
  }
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    mImagePerfState.setImageRequestStartTimeMs(mClock.now());
    mImagePerfState.setImageRequest(paramImageRequest);
    mImagePerfState.setCallerContext(paramObject);
    mImagePerfState.setRequestId(paramString);
    mImagePerfState.setPrefetch(paramBoolean);
  }
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    mImagePerfState.setImageRequestEndTimeMs(mClock.now());
    mImagePerfState.setImageRequest(paramImageRequest);
    mImagePerfState.setRequestId(paramString);
    mImagePerfState.setPrefetch(paramBoolean);
  }
}
