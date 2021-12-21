package com.facebook.react.uimanager.debug;

public abstract interface NotThreadSafeViewHierarchyUpdateDebugListener
{
  public abstract void onViewHierarchyUpdateEnqueued();
  
  public abstract void onViewHierarchyUpdateFinished();
}
