package com.facebook.react.jscexecutor;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;
import com.facebook.upgrade.HybridData;

@DoNotStrip
class JSCExecutor
  extends JavaScriptExecutor
{
  static
  {
    SoLoader.loadLibrary("jscexecutor");
  }
  
  JSCExecutor(ReadableNativeMap paramReadableNativeMap)
  {
    super(initHybrid(paramReadableNativeMap));
  }
  
  private static native HybridData initHybrid(ReadableNativeMap paramReadableNativeMap);
  
  public String getName()
  {
    return "JSCExecutor";
  }
}
