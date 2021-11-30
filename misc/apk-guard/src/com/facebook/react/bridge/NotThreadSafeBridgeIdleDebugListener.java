package com.facebook.react.bridge;

public abstract interface NotThreadSafeBridgeIdleDebugListener
{
  public abstract void onBridgeDestroyed();
  
  public abstract void onTransitionToBridgeBusy();
  
  public abstract void onTransitionToBridgeIdle();
}
