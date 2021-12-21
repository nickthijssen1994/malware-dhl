package com.facebook.upgrade;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CppSystemErrorException
  extends CppException
{
  int errorCode;
  
  public CppSystemErrorException(String paramString, int paramInt)
  {
    super(paramString);
    errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return errorCode;
  }
}
