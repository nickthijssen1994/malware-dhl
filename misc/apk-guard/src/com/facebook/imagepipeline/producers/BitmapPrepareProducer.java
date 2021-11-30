package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class BitmapPrepareProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String PRODUCER_NAME = "BitmapPrepareProducer";
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final int mMaxBitmapSizeBytes;
  private final int mMinBitmapSizeBytes;
  private final boolean mPreparePrefetch;
  
  public BitmapPrepareProducer(Producer paramProducer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool;
    if (paramInt1 <= paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    mMinBitmapSizeBytes = paramInt1;
    mMaxBitmapSizeBytes = paramInt2;
    mPreparePrefetch = paramBoolean;
  }
  
  public void produceResults(Consumer paramConsumer, ProducerContext paramProducerContext)
  {
    if ((paramProducerContext.isPrefetch()) && (!mPreparePrefetch))
    {
      mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
    mInputProducer.produceResults(new BitmapPrepareConsumer(paramConsumer, mMinBitmapSizeBytes, mMaxBitmapSizeBytes), paramProducerContext);
  }
  
  private static class BitmapPrepareConsumer
    extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private final int mMaxBitmapSizeBytes;
    private final int mMinBitmapSizeBytes;
    
    BitmapPrepareConsumer(Consumer paramConsumer, int paramInt1, int paramInt2)
    {
      super();
      mMinBitmapSizeBytes = paramInt1;
      mMaxBitmapSizeBytes = paramInt2;
    }
    
    private void internalPrepareBitmap(CloseableReference paramCloseableReference)
    {
      if (paramCloseableReference != null)
      {
        if (!paramCloseableReference.isValid()) {
          return;
        }
        paramCloseableReference = (CloseableImage)paramCloseableReference.get();
        if (paramCloseableReference != null)
        {
          if (paramCloseableReference.isClosed()) {
            return;
          }
          if ((paramCloseableReference instanceof CloseableStaticBitmap))
          {
            paramCloseableReference = ((CloseableStaticBitmap)paramCloseableReference).getUnderlyingBitmap();
            if (paramCloseableReference == null) {
              return;
            }
            int i = paramCloseableReference.getRowBytes() * paramCloseableReference.getHeight();
            if (i < mMinBitmapSizeBytes) {
              return;
            }
            if (i > mMaxBitmapSizeBytes) {
              return;
            }
            paramCloseableReference.prepareToDraw();
          }
        }
      }
    }
    
    protected void onNewResultImpl(CloseableReference paramCloseableReference, int paramInt)
    {
      internalPrepareBitmap(paramCloseableReference);
      getConsumer().onNewResult(paramCloseableReference, paramInt);
    }
  }
}
