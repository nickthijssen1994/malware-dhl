package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class NoSuchKeyException
  extends RuntimeException
{
  public NoSuchKeyException(String paramString)
  {
    super(paramString);
  }
}
