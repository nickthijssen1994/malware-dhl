package com.facebook.systrace;

public abstract interface TraceListener
{
  public abstract void onTraceStarted();
  
  public abstract void onTraceStopped();
}
