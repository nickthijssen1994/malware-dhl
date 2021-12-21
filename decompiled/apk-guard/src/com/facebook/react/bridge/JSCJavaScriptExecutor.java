package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.HybridData;

@DoNotStrip
class JSCJavaScriptExecutor
  extends JavaScriptExecutor
{
  static {}
  
  JSCJavaScriptExecutor(ReadableNativeMap paramReadableNativeMap)
  {
    super(initHybrid(paramReadableNativeMap));
  }
  
  private static native HybridData initHybrid(ReadableNativeMap paramReadableNativeMap);
  
  public String getName()
  {
    return "JSCJavaScriptExecutor";
  }
}
