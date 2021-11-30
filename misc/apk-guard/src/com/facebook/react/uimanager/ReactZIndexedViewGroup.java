package com.facebook.react.uimanager;

public abstract interface ReactZIndexedViewGroup
{
  public abstract int getZIndexMappedChildIndex(int paramInt);
  
  public abstract void updateDrawingOrder();
}
