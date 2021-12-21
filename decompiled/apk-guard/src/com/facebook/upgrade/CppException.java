package com.facebook.upgrade;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CppException
  extends RuntimeException
{
  public CppException(String paramString)
  {
    super(paramString);
  }
}
