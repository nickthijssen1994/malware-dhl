package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import java.util.Collection;
import java.util.Iterator;

public class ModuleDataCleaner
{
  public ModuleDataCleaner() {}
  
  public static void cleanDataFromModules(CatalystInstance paramCatalystInstance)
  {
    paramCatalystInstance = paramCatalystInstance.getNativeModules().iterator();
    while (paramCatalystInstance.hasNext())
    {
      NativeModule localNativeModule = (NativeModule)paramCatalystInstance.next();
      if ((localNativeModule instanceof Cleanable))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cleaning data from ");
        localStringBuilder.append(localNativeModule.getName());
        FLog.d("ReactNative", localStringBuilder.toString());
        ((Cleanable)localNativeModule).clearSensitiveData();
      }
    }
  }
  
  public static abstract interface Cleanable
  {
    public abstract void clearSensitiveData();
  }
}
