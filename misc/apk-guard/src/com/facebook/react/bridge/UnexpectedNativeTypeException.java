package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class UnexpectedNativeTypeException
  extends RuntimeException
{
  public UnexpectedNativeTypeException(String paramString)
  {
    super(paramString);
  }
}
