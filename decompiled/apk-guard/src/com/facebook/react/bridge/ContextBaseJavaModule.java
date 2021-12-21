package com.facebook.react.bridge;

import android.content.Context;

public abstract class ContextBaseJavaModule
  extends BaseJavaModule
{
  private final Context mContext;
  
  public ContextBaseJavaModule(Context paramContext)
  {
    mContext = paramContext;
  }
  
  protected final Context getContext()
  {
    return mContext;
  }
}
