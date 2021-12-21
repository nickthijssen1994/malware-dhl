package com.facebook.upgrade;

public class JniTerminateHandler
{
  public JniTerminateHandler() {}
  
  public static void handleTerminate(Throwable paramThrowable)
    throws Throwable
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    if (localUncaughtExceptionHandler == null) {
      return;
    }
    localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), paramThrowable);
  }
}
