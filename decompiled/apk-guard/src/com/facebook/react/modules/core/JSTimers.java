package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;

public abstract interface JSTimers
  extends JavaScriptModule
{
  public abstract void callIdleCallbacks(double paramDouble);
  
  public abstract void callTimers(WritableArray paramWritableArray);
  
  public abstract void emitTimeDriftWarning(String paramString);
}
