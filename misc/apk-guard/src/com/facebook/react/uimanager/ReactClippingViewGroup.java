package com.facebook.react.uimanager;

import android.graphics.Rect;

public abstract interface ReactClippingViewGroup
{
  public abstract void getClippingRect(Rect paramRect);
  
  public abstract boolean getRemoveClippedSubviews();
  
  public abstract void setRemoveClippedSubviews(boolean paramBoolean);
  
  public abstract void updateClippingRect();
}
