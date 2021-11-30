package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.HybridData;

@DoNotStrip
public abstract class NativeArray
  implements NativeArrayInterface
{
  @DoNotStrip
  private HybridData mHybridData;
  
  static {}
  
  protected NativeArray(HybridData paramHybridData)
  {
    mHybridData = paramHybridData;
  }
  
  public native String toString();
}
