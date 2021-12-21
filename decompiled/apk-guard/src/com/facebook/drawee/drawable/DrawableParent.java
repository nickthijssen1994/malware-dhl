package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;

public abstract interface DrawableParent
{
  public abstract Drawable getDrawable();
  
  public abstract Drawable setDrawable(Drawable paramDrawable);
}
