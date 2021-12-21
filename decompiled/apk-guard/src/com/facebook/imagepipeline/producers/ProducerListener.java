package com.facebook.imagepipeline.producers;

import java.util.Map;

public abstract interface ProducerListener
{
  public abstract void onProducerEvent(String paramString1, String paramString2, String paramString3);
  
  public abstract void onProducerFinishWithCancellation(String paramString1, String paramString2, Map paramMap);
  
  public abstract void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map paramMap);
  
  public abstract void onProducerFinishWithSuccess(String paramString1, String paramString2, Map paramMap);
  
  public abstract void onProducerStart(String paramString1, String paramString2);
  
  public abstract void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract boolean requiresExtraMap(String paramString);
}
