package com.facebook.common.lifecycle;

import android.view.View;

public abstract interface AttachDetachListener
{
  public abstract void onAttachToView(View paramView);
  
  public abstract void onDetachFromView(View paramView);
}
