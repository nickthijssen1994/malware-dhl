package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaScriptModule;

public abstract interface HMRClient
  extends JavaScriptModule
{
  public abstract void enable(String paramString1, String paramString2, String paramString3, int paramInt);
}
