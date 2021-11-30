package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class RetainingDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  @Nullable
  private Supplier<DataSource<T>> mCurrentDataSourceSupplier = null;
  private final Set<RetainingDataSource> mDataSources = Collections.newSetFromMap(new WeakHashMap());
  
  public RetainingDataSourceSupplier() {}
  
  public DataSource getFolder()
  {
    RetainingDataSource localRetainingDataSource = new RetainingDataSource(null);
    localRetainingDataSource.setSupplier(mCurrentDataSourceSupplier);
    mDataSources.add(localRetainingDataSource);
    return localRetainingDataSource;
  }
  
  public void replaceSupplier(Supplier paramSupplier)
  {
    mCurrentDataSourceSupplier = paramSupplier;
    Iterator localIterator = mDataSources.iterator();
    while (localIterator.hasNext())
    {
      RetainingDataSource localRetainingDataSource = (RetainingDataSource)localIterator.next();
      if (!localRetainingDataSource.isClosed()) {
        localRetainingDataSource.setSupplier(paramSupplier);
      }
    }
  }
  
  private static class RetainingDataSource<T>
    extends AbstractDataSource<T>
  {
    @Nullable
    @GuardedBy("RetainingDataSource.this")
    private DataSource<T> mDataSource = null;
    
    private RetainingDataSource() {}
    
    private static void closeSafely(DataSource paramDataSource)
    {
      if (paramDataSource != null) {
        paramDataSource.close();
      }
    }
    
    private void onDataSourceFailed(DataSource paramDataSource) {}
    
    private void onDataSourceNewResult(DataSource paramDataSource)
    {
      if (paramDataSource == mDataSource) {
        setResult(null, false);
      }
    }
    
    private void onDatasourceProgress(DataSource paramDataSource)
    {
      if (paramDataSource == mDataSource) {
        setProgress(paramDataSource.getProgress());
      }
    }
    
    public boolean close()
    {
      try
      {
        if (!super.close()) {
          return false;
        }
        DataSource localDataSource = mDataSource;
        mDataSource = null;
        closeSafely(localDataSource);
        return true;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public Object getResult()
    {
      try
      {
        Object localObject;
        if (mDataSource != null) {
          localObject = mDataSource.getResult();
        } else {
          localObject = null;
        }
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public boolean hasMultipleResults()
    {
      return true;
    }
    
    public boolean hasResult()
    {
      try
      {
        if (mDataSource != null)
        {
          bool = mDataSource.hasResult();
          if (bool)
          {
            bool = true;
            break label30;
          }
        }
        boolean bool = false;
        label30:
        return bool;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public void setSupplier(Supplier paramSupplier)
    {
      if (isClosed()) {
        return;
      }
      if (paramSupplier != null) {
        paramSupplier = (DataSource)paramSupplier.getFolder();
      } else {
        paramSupplier = null;
      }
      try
      {
        if (isClosed())
        {
          closeSafely(paramSupplier);
          return;
        }
        DataSource localDataSource = mDataSource;
        mDataSource = paramSupplier;
        if (paramSupplier != null) {
          paramSupplier.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        }
        closeSafely(localDataSource);
        return;
      }
      catch (Throwable paramSupplier)
      {
        throw paramSupplier;
      }
    }
    
    private class InternalDataSubscriber
      implements DataSubscriber<T>
    {
      private InternalDataSubscriber() {}
      
      public void onCancellation(DataSource paramDataSource) {}
      
      public void onFailure(DataSource paramDataSource)
      {
        RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed(paramDataSource);
      }
      
      public void onNewResult(DataSource paramDataSource)
      {
        if (paramDataSource.hasResult())
        {
          RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceNewResult(paramDataSource);
          return;
        }
        if (paramDataSource.isFinished()) {
          RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed(paramDataSource);
        }
      }
      
      public void onProgressUpdate(DataSource paramDataSource)
      {
        RetainingDataSourceSupplier.RetainingDataSource.this.onDatasourceProgress(paramDataSource);
      }
    }
  }
}
