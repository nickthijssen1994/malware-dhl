package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;

public abstract interface OnInterceptTouchEventListener
{
  public abstract boolean onInterceptTouchEvent(ViewGroup paramViewGroup, MotionEvent paramMotionEvent);
}
