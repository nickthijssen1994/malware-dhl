package com.facebook.react.devsupport.interfaces;

import com.facebook.react.bridge.NativeDeltaClient;

public abstract interface DevBundleDownloadListener
{
  public abstract void onFailure(Exception paramException);
  
  public abstract void onProgress(String paramString, Integer paramInteger1, Integer paramInteger2);
  
  public abstract void onSuccess(NativeDeltaClient paramNativeDeltaClient);
}
