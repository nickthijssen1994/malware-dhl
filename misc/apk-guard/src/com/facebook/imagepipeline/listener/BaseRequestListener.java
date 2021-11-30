package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

public class BaseRequestListener
  implements RequestListener
{
  public BaseRequestListener() {}
  
  public void onProducerEvent(String paramString1, String paramString2, String paramString3) {}
  
  public void onProducerFinishWithCancellation(String paramString1, String paramString2, Map paramMap) {}
  
  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map paramMap) {}
  
  public void onProducerFinishWithSuccess(String paramString1, String paramString2, Map paramMap) {}
  
  public void onProducerStart(String paramString1, String paramString2) {}
  
  public void onRequestCancellation(String paramString) {}
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean) {}
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean) {}
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean) {}
  
  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean) {}
  
  public boolean requiresExtraMap(String paramString)
  {
    return false;
  }
}
