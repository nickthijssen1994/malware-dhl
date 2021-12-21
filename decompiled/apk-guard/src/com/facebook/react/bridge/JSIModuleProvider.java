package com.facebook.react.bridge;

public abstract interface JSIModuleProvider<T extends JSIModule>
{
  public abstract JSIModule isFeatureEnabled();
}
