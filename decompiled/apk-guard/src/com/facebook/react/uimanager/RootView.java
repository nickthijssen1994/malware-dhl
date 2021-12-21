package com.facebook.react.uimanager;

import android.view.MotionEvent;

public abstract interface RootView
{
  public abstract void handleException(Throwable paramThrowable);
  
  public abstract void onChildStartedNativeGesture(MotionEvent paramMotionEvent);
}
