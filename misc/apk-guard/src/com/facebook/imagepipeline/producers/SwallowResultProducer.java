package com.facebook.imagepipeline.producers;

public class SwallowResultProducer<T>
  implements Producer<Void>
{
  private final Producer<T> mInputProducer;
  
  public SwallowResultProducer(Producer paramProducer)
  {
    mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new DelegatingConsumer(paramConsumer)
    {
      protected void onNewResultImpl(Object paramAnonymousObject, int paramAnonymousInt)
      {
        if (BaseConsumer.isLast(paramAnonymousInt)) {
          getConsumer().onNewResult(null, paramAnonymousInt);
        }
      }
    };
    mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
}
