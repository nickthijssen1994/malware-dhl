package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;

public abstract class BaseBitmapDataSubscriber
  extends BaseDataSubscriber<CloseableReference<CloseableImage>>
{
  public BaseBitmapDataSubscriber() {}
  
  protected abstract void onNewResultImpl(Bitmap paramBitmap);
  
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
      if ((localCloseableReference.get() instanceof CloseableBitmap)) {
        paramDataSource = ((CloseableBitmap)localCloseableReference.get()).getUnderlyingBitmap();
      }
    }
    try
    {
      onNewResultImpl(paramDataSource);
      CloseableReference.closeSafely(localCloseableReference);
      return;
    }
    catch (Throwable paramDataSource)
    {
      CloseableReference.closeSafely(localCloseableReference);
      throw paramDataSource;
    }
  }
}
