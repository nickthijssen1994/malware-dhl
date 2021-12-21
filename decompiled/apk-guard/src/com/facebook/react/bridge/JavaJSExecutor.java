package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface JavaJSExecutor
{
  public abstract void close();
  
  public abstract String executeJSCall(String paramString1, String paramString2)
    throws JavaJSExecutor.ProxyExecutorException;
  
  public abstract void loadApplicationScript(String paramString)
    throws JavaJSExecutor.ProxyExecutorException;
  
  public abstract void setGlobalVariable(String paramString1, String paramString2);
  
  public static abstract interface Factory
  {
    public abstract JavaJSExecutor create()
      throws Exception;
  }
  
  public static class ProxyExecutorException
    extends Exception
  {
    public ProxyExecutorException(Throwable paramThrowable)
    {
      super();
    }
  }
}
