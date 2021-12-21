package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

public abstract interface RequestListener
  extends ProducerListener
{
  public abstract void onRequestCancellation(String paramString);
  
  public abstract void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean);
  
  public abstract void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean);
  
  public abstract void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean);
}
