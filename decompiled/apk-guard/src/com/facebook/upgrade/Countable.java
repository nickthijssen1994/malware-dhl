package com.facebook.upgrade;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class Countable
{
  @DoNotStrip
  private long mInstance = 0L;
  
  static
  {
    SoLoader.loadLibrary("fb");
  }
  
  public Countable() {}
  
  public native void dispose();
  
  protected void finalize()
    throws Throwable
  {
    dispose();
    super.finalize();
  }
}
