package com.facebook.imagepipeline.request;

public abstract interface RepeatedPostprocessor
  extends Postprocessor
{
  public abstract void setCallback(RepeatedPostprocessorRunner paramRepeatedPostprocessorRunner);
}
