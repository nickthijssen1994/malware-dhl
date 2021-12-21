package com.facebook.common.activitylistener;

public abstract interface ListenableActivity
{
  public abstract void addActivityListener(ActivityListener paramActivityListener);
  
  public abstract void removeActivityListener(ActivityListener paramActivityListener);
}
