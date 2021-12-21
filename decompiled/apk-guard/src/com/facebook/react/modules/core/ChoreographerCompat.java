package com.facebook.react.modules.core;

import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.react.bridge.UiThreadUtil;

public class ChoreographerCompat
{
  private static final long ONE_FRAME_MILLIS = 17L;
  private static ChoreographerCompat sInstance;
  private Choreographer mChoreographer = getChoreographer();
  private Handler mHandler;
  
  private ChoreographerCompat() {}
  
  private void choreographerPostFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    mChoreographer.postFrameCallback(paramFrameCallback);
  }
  
  private void choreographerPostFrameCallbackDelayed(Choreographer.FrameCallback paramFrameCallback, long paramLong)
  {
    mChoreographer.postFrameCallbackDelayed(paramFrameCallback, paramLong);
  }
  
  private void choreographerRemoveFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    mChoreographer.removeFrameCallback(paramFrameCallback);
  }
  
  private Choreographer getChoreographer()
  {
    return Choreographer.getInstance();
  }
  
  public static ChoreographerCompat getInstance()
  {
    
    if (sInstance == null) {
      sInstance = new ChoreographerCompat();
    }
    return sInstance;
  }
  
  public void postFrameCallback(FrameCallback paramFrameCallback)
  {
    choreographerPostFrameCallback(paramFrameCallback.getFrameCallback());
  }
  
  public void postFrameCallbackDelayed(FrameCallback paramFrameCallback, long paramLong)
  {
    choreographerPostFrameCallbackDelayed(paramFrameCallback.getFrameCallback(), paramLong);
  }
  
  public void removeFrameCallback(FrameCallback paramFrameCallback)
  {
    choreographerRemoveFrameCallback(paramFrameCallback.getFrameCallback());
  }
  
  public static abstract class FrameCallback
  {
    private Choreographer.FrameCallback mFrameCallback;
    private Runnable mRunnable;
    
    public FrameCallback() {}
    
    public abstract void doFrame(long paramLong);
    
    Choreographer.FrameCallback getFrameCallback()
    {
      if (mFrameCallback == null) {
        mFrameCallback = new Choreographer.FrameCallback()
        {
          public void doFrame(long paramAnonymousLong)
          {
            ChoreographerCompat.FrameCallback.this.doFrame(paramAnonymousLong);
          }
        };
      }
      return mFrameCallback;
    }
    
    Runnable getRunnable()
    {
      if (mRunnable == null) {
        mRunnable = new Runnable()
        {
          public void run()
          {
            doFrame(System.nanoTime());
          }
        };
      }
      return mRunnable;
    }
  }
}
