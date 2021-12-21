package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface DraweeHierarchy
{
  public abstract Drawable getTopLevelDrawable();
}
