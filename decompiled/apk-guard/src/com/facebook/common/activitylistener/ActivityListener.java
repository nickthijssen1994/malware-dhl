package com.facebook.common.activitylistener;

import android.app.Activity;

public abstract interface ActivityListener
{
  public static final int MAX_PRIORITY = 10;
  public static final int MIN_PRIORITY = 1;
  
  public abstract int getPriority();
  
  public abstract void onActivityCreate(Activity paramActivity);
  
  public abstract void onDestroy(Activity paramActivity);
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onResume(Activity paramActivity);
  
  public abstract void onStart(Activity paramActivity);
  
  public abstract void onStop(Activity paramActivity);
}
