package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;

public abstract interface RCTNativeAppEventEmitter
  extends JavaScriptModule
{
  public abstract void emit(String paramString, Object paramObject);
}
