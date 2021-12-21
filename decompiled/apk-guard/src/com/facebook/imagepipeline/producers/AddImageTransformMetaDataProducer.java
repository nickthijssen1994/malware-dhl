package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

public class AddImageTransformMetaDataProducer
  implements Producer<EncodedImage>
{
  private final Producer<EncodedImage> mInputProducer;
  
  public AddImageTransformMetaDataProducer(Producer paramProducer)
  {
    mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer paramConsumer, ProducerContext paramProducerContext)
  {
    mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(paramConsumer, null), paramProducerContext);
  }
  
  private static class AddImageTransformMetaDataConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private AddImageTransformMetaDataConsumer(Consumer paramConsumer)
    {
      super();
    }
    
    protected void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      if (paramEncodedImage == null)
      {
        getConsumer().onNewResult(null, paramInt);
        return;
      }
      if (!EncodedImage.isMetaDataAvailable(paramEncodedImage)) {
        paramEncodedImage.parseMetaData();
      }
      getConsumer().onNewResult(paramEncodedImage, paramInt);
    }
  }
}
