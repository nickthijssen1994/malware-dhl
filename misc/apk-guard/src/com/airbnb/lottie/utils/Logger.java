package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

public class Logger
{
  private static LottieLogger INSTANCE = new LogcatLogger();
  
  public Logger() {}
  
  public static void debug(String paramString)
  {
    INSTANCE.debug(paramString);
  }
  
  public static void debug(String paramString, Throwable paramThrowable)
  {
    INSTANCE.debug(paramString, paramThrowable);
  }
  
  public static void error(String paramString, Throwable paramThrowable)
  {
    INSTANCE.error(paramString, paramThrowable);
  }
  
  public static void setInstance(LottieLogger paramLottieLogger)
  {
    INSTANCE = paramLottieLogger;
  }
  
  public static void warning(String paramString)
  {
    INSTANCE.warning(paramString);
  }
  
  public static void warning(String paramString, Throwable paramThrowable)
  {
    INSTANCE.warning(paramString, paramThrowable);
  }
}
