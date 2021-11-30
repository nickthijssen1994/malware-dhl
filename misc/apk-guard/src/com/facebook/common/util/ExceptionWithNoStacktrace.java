package com.facebook.common.util;

public class ExceptionWithNoStacktrace
  extends Exception
{
  public ExceptionWithNoStacktrace(String paramString)
  {
    super(paramString);
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
}
