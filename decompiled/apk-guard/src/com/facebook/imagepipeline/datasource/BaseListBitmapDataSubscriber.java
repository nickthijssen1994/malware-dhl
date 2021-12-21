package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber
  extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>>
{
  public BaseListBitmapDataSubscriber() {}
  
  public void onNewResultImpl(DataSource paramDataSource)
  {
    if (!paramDataSource.isFinished()) {
      return;
    }
    paramDataSource = (List)paramDataSource.getResult();
    if (paramDataSource == null)
    {
      onNewResultListImpl(null);
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(paramDataSource.size());
      Iterator localIterator = paramDataSource.iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        CloseableReference localCloseableReference = (CloseableReference)localIterator.next();
        if (localCloseableReference != null)
        {
          bool = localCloseableReference.get() instanceof CloseableBitmap;
          if (bool)
          {
            localArrayList.add(((CloseableBitmap)localCloseableReference.get()).getUnderlyingBitmap());
            continue;
          }
        }
        localArrayList.add(null);
      }
      onNewResultListImpl(localArrayList);
      paramDataSource = paramDataSource.iterator();
      while (paramDataSource.hasNext()) {
        CloseableReference.closeSafely((CloseableReference)paramDataSource.next());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      paramDataSource = paramDataSource.iterator();
      while (paramDataSource.hasNext()) {
        CloseableReference.closeSafely((CloseableReference)paramDataSource.next());
      }
      throw localThrowable;
    }
  }
  
  protected abstract void onNewResultListImpl(List paramList);
}
