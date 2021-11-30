package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.facebook.upgrade.HybridData;
import java.io.File;

@DoNotStrip
public class CxxModuleWrapper
  extends CxxModuleWrapperBase
{
  protected CxxModuleWrapper(HybridData paramHybridData)
  {
    super(paramHybridData);
  }
  
  public static CxxModuleWrapper makeDso(String paramString1, String paramString2)
  {
    SoLoader.loadLibrary(paramString1);
    return makeDsoNative(SoLoader.unpackLibraryAndDependencies(paramString1).getAbsolutePath(), paramString2);
  }
  
  private static native CxxModuleWrapper makeDsoNative(String paramString1, String paramString2);
}
