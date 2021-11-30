package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.HybridData;

@DoNotStrip
public abstract class NativeMap
{
  @DoNotStrip
  private HybridData mHybridData;
  
  static {}
  
  public NativeMap(HybridData paramHybridData)
  {
    mHybridData = paramHybridData;
  }
  
  public native String toString();
}
