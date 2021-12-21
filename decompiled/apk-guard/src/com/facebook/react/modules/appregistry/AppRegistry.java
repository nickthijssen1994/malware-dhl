package com.facebook.react.modules.appregistry;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;

public abstract interface AppRegistry
  extends JavaScriptModule
{
  public abstract void runApplication(String paramString, WritableMap paramWritableMap);
  
  public abstract void startHeadlessTask(int paramInt, String paramString, WritableMap paramWritableMap);
  
  public abstract void unmountApplicationComponentAtRootTag(int paramInt);
}
