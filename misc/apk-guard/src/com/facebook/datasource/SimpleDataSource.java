package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;

public class SimpleDataSource<T>
  extends AbstractDataSource<T>
{
  private SimpleDataSource() {}
  
  public static SimpleDataSource create()
  {
    return new SimpleDataSource();
  }
  
  public boolean setFailure(Throwable paramThrowable)
  {
    return super.setFailure((Throwable)Preconditions.checkNotNull(paramThrowable));
  }
  
  public boolean setProgress(float paramFloat)
  {
    return super.setProgress(paramFloat);
  }
  
  public boolean setResult(Object paramObject)
  {
    return super.setResult(Preconditions.checkNotNull(paramObject), true);
  }
  
  public boolean setResult(Object paramObject, boolean paramBoolean)
  {
    return super.setResult(Preconditions.checkNotNull(paramObject), paramBoolean);
  }
}
