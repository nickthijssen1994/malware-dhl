package com.facebook.datasource;

public abstract class BaseBooleanSubscriber
  implements DataSubscriber<Boolean>
{
  public BaseBooleanSubscriber() {}
  
  public void onCancellation(DataSource paramDataSource) {}
  
  public void onFailure(DataSource paramDataSource)
  {
    try
    {
      onFailureImpl(paramDataSource);
      paramDataSource.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramDataSource.close();
      throw localThrowable;
    }
  }
  
  protected abstract void onFailureImpl(DataSource paramDataSource);
  
  public void onNewResult(DataSource paramDataSource)
  {
    try
    {
      onNewResultImpl(((Boolean)paramDataSource.getResult()).booleanValue());
      paramDataSource.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramDataSource.close();
      throw localThrowable;
    }
  }
  
  protected abstract void onNewResultImpl(boolean paramBoolean);
  
  public void onProgressUpdate(DataSource paramDataSource) {}
}
