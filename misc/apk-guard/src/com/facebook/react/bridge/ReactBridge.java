package com.facebook.react.bridge;

import android.os.SystemClock;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;

public class ReactBridge
{
  private static boolean sDidInit;
  private static volatile long sLoadEndTime;
  private static volatile long sLoadStartTime;
  
  public ReactBridge() {}
  
  public static long getLoadEndTime()
  {
    return sLoadEndTime;
  }
  
  public static long getLoadStartTime()
  {
    return sLoadStartTime;
  }
  
  public static void staticInit()
  {
    try
    {
      boolean bool = sDidInit;
      if (bool) {
        return;
      }
      sDidInit = true;
      sLoadStartTime = SystemClock.uptimeMillis();
      Systrace.beginSection(0L, "ReactBridge.staticInit::load:reactnativejni");
      ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
      SoLoader.loadLibrary("reactnativejni");
      ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
      Systrace.endSection(0L);
      sLoadEndTime = SystemClock.uptimeMillis();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
