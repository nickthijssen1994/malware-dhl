package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

public class RemoveImageTransformMetaDataProducer
  implements Producer<CloseableReference<PooledByteBuffer>>
{
  private final Producer<EncodedImage> mInputProducer;
  
  public RemoveImageTransformMetaDataProducer(Producer paramProducer)
  {
    mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer paramConsumer, ProducerContext paramProducerContext)
  {
    mInputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(paramConsumer, null), paramProducerContext);
  }
  
  private class RemoveImageTransformMetaDataConsumer
    extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>>
  {
    private RemoveImageTransformMetaDataConsumer(Consumer paramConsumer)
    {
      super();
    }
    
    protected void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      Object localObject2 = null;
      CloseableReference localCloseableReference = null;
      Object localObject1 = localObject2;
      try
      {
        boolean bool = EncodedImage.isValid(paramEncodedImage);
        if (bool)
        {
          localObject1 = localObject2;
          localCloseableReference = paramEncodedImage.getByteBufferRef();
        }
        localObject1 = localCloseableReference;
        getConsumer().onNewResult(localCloseableReference, paramInt);
        CloseableReference.closeSafely(localCloseableReference);
        return;
      }
      catch (Throwable paramEncodedImage)
      {
        CloseableReference.closeSafely((CloseableReference)localObject1);
        throw paramEncodedImage;
      }
    }
  }
}
