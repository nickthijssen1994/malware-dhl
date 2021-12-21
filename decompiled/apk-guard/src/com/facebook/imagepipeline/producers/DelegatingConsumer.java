package com.facebook.imagepipeline.producers;

public abstract class DelegatingConsumer<I, O>
  extends BaseConsumer<I>
{
  private final Consumer<O> mConsumer;
  
  public DelegatingConsumer(Consumer paramConsumer)
  {
    mConsumer = paramConsumer;
  }
  
  public Consumer getConsumer()
  {
    return mConsumer;
  }
  
  protected void onCancellationImpl()
  {
    mConsumer.onCancellation();
  }
  
  protected void onFailureImpl(Throwable paramThrowable)
  {
    mConsumer.onFailure(paramThrowable);
  }
  
  protected void onProgressUpdateImpl(float paramFloat)
  {
    mConsumer.onProgressUpdate(paramFloat);
  }
}
