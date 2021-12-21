package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
abstract interface ReactCallback
{
  public abstract void decrementPendingJSCalls();
  
  public abstract void incrementPendingJSCalls();
  
  public abstract void onBatchComplete();
}
