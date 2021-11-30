package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class InvalidIteratorException
  extends RuntimeException
{
  public InvalidIteratorException(String paramString)
  {
    super(paramString);
  }
}
