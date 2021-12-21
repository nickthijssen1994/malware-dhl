package com.facebook.common.executors;

import java.util.concurrent.ScheduledExecutorService;

public abstract interface HandlerExecutorService
  extends ScheduledExecutorService
{
  public abstract boolean isHandlerThread();
  
  public abstract void quit();
}
