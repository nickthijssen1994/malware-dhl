package com.facebook.upgrade;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class UnknownCppException
  extends CppException
{
  public UnknownCppException()
  {
    super("Unknown");
  }
  
  public UnknownCppException(String paramString)
  {
    super(paramString);
  }
}
