package com.facebook.react.bridge.queue;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.HybridData;

@DoNotStrip
public class NativeRunnable
  implements Runnable
{
  private final HybridData mHybridData;
  
  private NativeRunnable(HybridData paramHybridData)
  {
    mHybridData = paramHybridData;
  }
  
  public native void run();
}
