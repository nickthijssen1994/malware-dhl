package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.HybridData;

@DoNotStrip
public abstract class JavaScriptExecutor
{
  private final HybridData mHybridData;
  
  protected JavaScriptExecutor(HybridData paramHybridData)
  {
    mHybridData = paramHybridData;
  }
  
  public void close()
  {
    mHybridData.resetNative();
  }
  
  public abstract String getName();
}
