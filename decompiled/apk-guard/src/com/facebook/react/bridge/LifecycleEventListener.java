package com.facebook.react.bridge;

public abstract interface LifecycleEventListener
{
  public abstract void onHostDestroy();
  
  public abstract void onHostPause();
  
  public abstract void onHostResume();
}
