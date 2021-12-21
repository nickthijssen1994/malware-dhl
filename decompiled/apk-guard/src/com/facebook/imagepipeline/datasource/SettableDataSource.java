package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class SettableDataSource<T>
  extends AbstractDataSource<CloseableReference<T>>
{
  private SettableDataSource() {}
  
  public static SettableDataSource create()
  {
    return new SettableDataSource();
  }
  
  protected void closeResult(CloseableReference paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }
  
  public CloseableReference getResult()
  {
    return CloseableReference.cloneOrNull((CloseableReference)super.getResult());
  }
  
  public boolean setException(Throwable paramThrowable)
  {
    return super.setFailure(paramThrowable);
  }
  
  public boolean setProgress(float paramFloat)
  {
    return super.setProgress(paramFloat);
  }
  
  public boolean setResult(CloseableReference paramCloseableReference)
  {
    return super.setResult(CloseableReference.cloneOrNull(paramCloseableReference), true);
  }
}
