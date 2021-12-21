package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;

public class NativeGestureUtil
{
  public NativeGestureUtil() {}
  
  public static void notifyNativeGestureStarted(View paramView, MotionEvent paramMotionEvent)
  {
    RootViewUtil.getRootView(paramView).onChildStartedNativeGesture(paramMotionEvent);
  }
}
