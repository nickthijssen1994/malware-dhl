package com.facebook.react.devsupport;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class JSException
  extends Exception
{
  private final String mStack;
  
  public JSException(String paramString1, String paramString2)
  {
    super(paramString1);
    mStack = paramString2;
  }
  
  public JSException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramThrowable);
    mStack = paramString2;
  }
  
  public String getStack()
  {
    return mStack;
  }
}
