package com.facebook.upgrade;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class CpuCapabilitiesJni
{
  static
  {
    SoLoader.loadLibrary("fb");
  }
  
  public CpuCapabilitiesJni() {}
  
  public static native boolean nativeDeviceSupportsNeon();
  
  public static native boolean nativeDeviceSupportsVFPFP16();
  
  public static native boolean nativeDeviceSupportsX86();
}
