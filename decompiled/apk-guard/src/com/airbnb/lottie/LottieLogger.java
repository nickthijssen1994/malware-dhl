package com.airbnb.lottie;

public abstract interface LottieLogger
{
  public abstract void debug(String paramString);
  
  public abstract void debug(String paramString, Throwable paramThrowable);
  
  public abstract void error(String paramString, Throwable paramThrowable);
  
  public abstract void warning(String paramString);
  
  public abstract void warning(String paramString, Throwable paramThrowable);
}
