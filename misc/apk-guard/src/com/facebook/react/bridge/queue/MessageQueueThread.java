package com.facebook.react.bridge.queue;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
public abstract interface MessageQueueThread
{
  public abstract void assertIsOnThread();
  
  public abstract void assertIsOnThread(String paramString);
  
  public abstract Future callOnQueue(Callable paramCallable);
  
  public abstract MessageQueueThreadPerfStats getPerfStats();
  
  public abstract boolean isOnThread();
  
  public abstract void quitSynchronous();
  
  public abstract void resetPerfStats();
  
  public abstract void runOnQueue(Runnable paramRunnable);
}
