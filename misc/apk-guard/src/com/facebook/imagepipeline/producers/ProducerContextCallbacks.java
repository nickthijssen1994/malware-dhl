package com.facebook.imagepipeline.producers;

public abstract interface ProducerContextCallbacks
{
  public abstract void onCancellationRequested();
  
  public abstract void onIsIntermediateResultExpectedChanged();
  
  public abstract void onIsPrefetchChanged();
  
  public abstract void onPriorityChanged();
}
