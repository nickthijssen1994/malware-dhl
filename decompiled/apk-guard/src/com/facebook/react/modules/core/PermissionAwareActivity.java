package com.facebook.react.modules.core;

public abstract interface PermissionAwareActivity
{
  public abstract int checkPermission(String paramString, int paramInt1, int paramInt2);
  
  public abstract int checkSelfPermission(String paramString);
  
  public abstract void requestPermissions(String[] paramArrayOfString, int paramInt, PermissionListener paramPermissionListener);
  
  public abstract boolean shouldShowRequestPermissionRationale(String paramString);
}
