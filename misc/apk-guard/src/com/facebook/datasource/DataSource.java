package com.facebook.datasource;

import java.util.concurrent.Executor;

public abstract interface DataSource<T>
{
  public abstract boolean close();
  
  public abstract Throwable getFailureCause();
  
  public abstract float getProgress();
  
  public abstract Object getResult();
  
  public abstract boolean hasFailed();
  
  public abstract boolean hasMultipleResults();
  
  public abstract boolean hasResult();
  
  public abstract boolean isClosed();
  
  public abstract boolean isFinished();
  
  public abstract void subscribe(DataSubscriber paramDataSubscriber, Executor paramExecutor);
}
