.class public interface abstract Lcom/facebook/imagepipeline/listener/RequestListener2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/facebook/imagepipeline/producers/ProducerListener2;


# virtual methods
.method public abstract onRequestCancellation(Lcom/facebook/imagepipeline/producers/ProducerContext;)V
    .param p1    # Lcom/facebook/imagepipeline/producers/ProducerContext;
        .annotation build Landroidx/annotation/NonNull;
        .end annotation
    .end param
.end method

.method public abstract onRequestFailure(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/Throwable;)V
    .param p1    # Lcom/facebook/imagepipeline/producers/ProducerContext;
        .annotation build Landroidx/annotation/NonNull;
        .end annotation
    .end param
.end method

.method public abstract onRequestStart(Lcom/facebook/imagepipeline/producers/ProducerContext;)V
    .param p1    # Lcom/facebook/imagepipeline/producers/ProducerContext;
        .annotation build Landroidx/annotation/NonNull;
        .end annotation
    .end param
.end method

.method public abstract onRequestSuccess(Lcom/facebook/imagepipeline/producers/ProducerContext;)V
    .param p1    # Lcom/facebook/imagepipeline/producers/ProducerContext;
        .annotation build Landroidx/annotation/NonNull;
        .end annotation
    .end param
.end method
