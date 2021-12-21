package com.facebook.react.bridge;

public abstract interface JSIModule
{
  public abstract void initialize();
  
  public abstract void onCatalystInstanceDestroy();
}
