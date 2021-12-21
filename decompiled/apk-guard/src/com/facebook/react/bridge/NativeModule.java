package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface NativeModule
{
  public abstract boolean canOverrideExistingModule();
  
  public abstract String getName();
  
  public abstract void initialize();
  
  public abstract void onCatalystInstanceDestroy();
  
  public static abstract interface NativeMethod
  {
    public abstract String getType();
    
    public abstract void invoke(JSInstance paramJSInstance, ReadableArray paramReadableArray);
  }
}
