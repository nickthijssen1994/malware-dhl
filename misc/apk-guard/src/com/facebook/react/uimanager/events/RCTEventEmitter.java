package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

public abstract interface RCTEventEmitter
  extends JavaScriptModule
{
  public abstract void receiveEvent(int paramInt, String paramString, WritableMap paramWritableMap);
  
  public abstract void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2);
}
