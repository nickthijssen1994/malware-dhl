package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public abstract class BaseBitmapReferenceDataSubscriber
  extends BaseDataSubscriber<CloseableReference<CloseableImage>>
{
  public BaseBitmapReferenceDataSubscriber() {}
  
  protected abstract void onNewResultImpl(CloseableReference paramCloseableReference);
  
  public void onNewResultImpl(DataSource paramDataSource)
  {
    if (!paramDataSource.isFinished()) {
      return;
    }
    CloseableReference localCloseableReference = (CloseableReference)paramDataSource.getResult();
    Object localObject = null;
    paramDataSource = localObject;
    if (localCloseableReference != null)
    {
      paramDataSource = localObject;
      if ((localCloseableReference.get() instanceof CloseableStaticBitmap)) {
        paramDataSource = ((CloseableStaticBitmap)localCloseableReference.get()).cloneUnderlyingBitmapReference();
      }
    }
    try
    {
      onNewResultImpl(paramDataSource);
      CloseableReference.closeSafely(paramDataSource);
      CloseableReference.closeSafely(localCloseableReference);
      return;
    }
    catch (Throwable localThrowable)
    {
      CloseableReference.closeSafely(paramDataSource);
      CloseableReference.closeSafely(localCloseableReference);
      throw localThrowable;
    }
  }
}
