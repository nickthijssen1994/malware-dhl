package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;

public class ListDataSource<T>
  extends AbstractDataSource<List<CloseableReference<T>>>
{
  private final DataSource<CloseableReference<T>>[] mDataSources;
  @GuardedBy("this")
  private int mFinishedDataSources;
  
  protected ListDataSource(DataSource[] paramArrayOfDataSource)
  {
    mDataSources = paramArrayOfDataSource;
    mFinishedDataSources = 0;
  }
  
  public static ListDataSource create(DataSource... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs);
    int j = paramVarArgs.length;
    int i = 0;
    boolean bool;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    ListDataSource localListDataSource = new ListDataSource(paramVarArgs);
    j = paramVarArgs.length;
    while (i < j)
    {
      DataSource localDataSource = paramVarArgs[i];
      if (localDataSource != null)
      {
        localListDataSource.getClass();
        localDataSource.subscribe(new InternalDataSubscriber(localListDataSource, null), CallerThreadExecutor.getInstance());
      }
      i += 1;
    }
    return localListDataSource;
  }
  
  private boolean increaseAndCheckIfLast()
  {
    try
    {
      int i = mFinishedDataSources;
      boolean bool = true;
      i += 1;
      mFinishedDataSources = i;
      int j = mDataSources.length;
      if (i != j) {
        bool = false;
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void onDataSourceCancelled()
  {
    setFailure(new CancellationException());
  }
  
  private void onDataSourceFailed(DataSource paramDataSource)
  {
    setFailure(paramDataSource.getFailureCause());
  }
  
  private void onDataSourceFinished()
  {
    if (increaseAndCheckIfLast()) {
      setResult(null, true);
    }
  }
  
  private void onDataSourceProgress()
  {
    DataSource[] arrayOfDataSource = mDataSources;
    int j = arrayOfDataSource.length;
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += arrayOfDataSource[i].getProgress();
      i += 1;
    }
    setProgress(f / mDataSources.length);
  }
  
  public boolean close()
  {
    boolean bool = super.close();
    int i = 0;
    if (!bool) {
      return false;
    }
    DataSource[] arrayOfDataSource = mDataSources;
    int j = arrayOfDataSource.length;
    while (i < j)
    {
      arrayOfDataSource[i].close();
      i += 1;
    }
    return true;
  }
  
  public List getResult()
  {
    try
    {
      boolean bool = hasResult();
      if (!bool) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(mDataSources.length);
      DataSource[] arrayOfDataSource = mDataSources;
      int j = arrayOfDataSource.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(arrayOfDataSource[i].getResult());
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean hasResult()
  {
    try
    {
      if (!isClosed())
      {
        int i = mFinishedDataSources;
        int j = mDataSources.length;
        if (i == j)
        {
          bool = true;
          break label32;
        }
      }
      boolean bool = false;
      label32:
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private class InternalDataSubscriber
    implements DataSubscriber<CloseableReference<T>>
  {
    @GuardedBy("InternalDataSubscriber.this")
    boolean mFinished = false;
    
    private InternalDataSubscriber() {}
    
    private boolean tryFinish()
    {
      try
      {
        boolean bool = mFinished;
        if (bool) {
          return false;
        }
        mFinished = true;
        return true;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public void onCancellation(DataSource paramDataSource)
    {
      ListDataSource.this.onDataSourceCancelled();
    }
    
    public void onFailure(DataSource paramDataSource)
    {
      ListDataSource.this.onDataSourceFailed(paramDataSource);
    }
    
    public void onNewResult(DataSource paramDataSource)
    {
      if ((paramDataSource.isFinished()) && (tryFinish())) {
        ListDataSource.this.onDataSourceFinished();
      }
    }
    
    public void onProgressUpdate(DataSource paramDataSource)
    {
      ListDataSource.this.onDataSourceProgress();
    }
  }
}
