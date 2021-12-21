package com.facebook.datasource;

public abstract interface DataSubscriber<T>
{
  public abstract void onCancellation(DataSource paramDataSource);
  
  public abstract void onFailure(DataSource paramDataSource);
  
  public abstract void onNewResult(DataSource paramDataSource);
  
  public abstract void onProgressUpdate(DataSource paramDataSource);
}
