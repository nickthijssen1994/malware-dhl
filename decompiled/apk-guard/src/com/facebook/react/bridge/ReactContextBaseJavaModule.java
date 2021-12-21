package com.facebook.react.bridge;

import android.app.Activity;

public abstract class ReactContextBaseJavaModule
  extends BaseJavaModule
{
  private final ReactApplicationContext mReactApplicationContext;
  
  public ReactContextBaseJavaModule(ReactApplicationContext paramReactApplicationContext)
  {
    mReactApplicationContext = paramReactApplicationContext;
  }
  
  protected final Activity getCurrentActivity()
  {
    return mReactApplicationContext.getCurrentActivity();
  }
  
  protected final ReactApplicationContext getReactApplicationContext()
  {
    return mReactApplicationContext;
  }
}
