package com.facebook.react.bridge;

import java.util.Map;

public abstract interface PerformanceCounter
{
  public abstract Map getPerformanceCounters();
  
  public abstract void profileNextBatch();
}
