package com.facebook.imagepipeline.producers;

/* loaded from: classes.dex */
public class NullProducer<T> implements Producer<T> {
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        consumer.onNewResult(null, 1);
    }
}
