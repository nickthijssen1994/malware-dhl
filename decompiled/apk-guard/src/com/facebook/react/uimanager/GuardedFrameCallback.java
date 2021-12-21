package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;

public abstract class GuardedFrameCallback
  extends ChoreographerCompat.FrameCallback
{
  private final ReactContext mReactContext;
  
  protected GuardedFrameCallback(ReactContext paramReactContext)
  {
    mReactContext = paramReactContext;
  }
  
  public final void doFrame(long paramLong)
  {
    try
    {
      doFrameGuarded(paramLong);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      mReactContext.handleException(localRuntimeException);
    }
  }
  
  protected abstract void doFrameGuarded(long paramLong);
}
