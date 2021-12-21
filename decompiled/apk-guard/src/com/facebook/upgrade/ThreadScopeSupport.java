package com.facebook.upgrade;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class ThreadScopeSupport
{
  static
  {
    SoLoader.loadLibrary("fb");
  }
  
  public ThreadScopeSupport() {}
  
  private static void runStdFunction(long paramLong)
  {
    runStdFunctionImpl(paramLong);
  }
  
  private static native void runStdFunctionImpl(long paramLong);
}
