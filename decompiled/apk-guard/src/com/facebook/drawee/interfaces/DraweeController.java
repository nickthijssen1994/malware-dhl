package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface DraweeController
{
  public abstract Animatable getAnimatable();
  
  public abstract String getContentDescription();
  
  public abstract DraweeHierarchy getHierarchy();
  
  public abstract boolean isSameImageRequest(DraweeController paramDraweeController);
  
  public abstract void onAttach();
  
  public abstract void onDetach();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void onViewportVisibilityHint(boolean paramBoolean);
  
  public abstract void setContentDescription(String paramString);
  
  public abstract void setHierarchy(DraweeHierarchy paramDraweeHierarchy);
}
