package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface Systrace
  extends JavaScriptModule
{
  public abstract void setEnabled(boolean paramBoolean);
}
