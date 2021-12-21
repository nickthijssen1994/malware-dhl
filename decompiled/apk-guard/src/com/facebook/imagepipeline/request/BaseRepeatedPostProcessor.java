package com.facebook.imagepipeline.request;

public abstract class BaseRepeatedPostProcessor
  extends BasePostprocessor
  implements RepeatedPostprocessor
{
  private RepeatedPostprocessorRunner mCallback;
  
  public BaseRepeatedPostProcessor() {}
  
  private RepeatedPostprocessorRunner getCallback()
  {
    try
    {
      RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = mCallback;
      return localRepeatedPostprocessorRunner;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void setCallback(RepeatedPostprocessorRunner paramRepeatedPostprocessorRunner)
  {
    try
    {
      mCallback = paramRepeatedPostprocessorRunner;
      return;
    }
    catch (Throwable paramRepeatedPostprocessorRunner)
    {
      throw paramRepeatedPostprocessorRunner;
    }
  }
  
  public void update()
  {
    RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = getCallback();
    if (localRepeatedPostprocessorRunner != null) {
      localRepeatedPostprocessorRunner.update();
    }
  }
}
