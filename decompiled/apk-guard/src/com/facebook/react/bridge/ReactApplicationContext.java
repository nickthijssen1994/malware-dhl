package com.facebook.react.bridge;

import android.content.Context;

public class ReactApplicationContext
  extends ReactContext
{
  public ReactApplicationContext(Context paramContext)
  {
    super(paramContext.getApplicationContext());
  }
}
