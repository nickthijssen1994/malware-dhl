package com.facebook.imagepipeline.producers;

public class NullProducer<T>
  implements Producer<T>
{
  public NullProducer() {}
  
  public void produceResults(Consumer paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer.onNewResult(null, 1);
  }
}
