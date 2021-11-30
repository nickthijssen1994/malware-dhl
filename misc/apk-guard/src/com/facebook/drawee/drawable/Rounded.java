package com.facebook.drawee.drawable;

public abstract interface Rounded
{
  public abstract int getBorderColor();
  
  public abstract float getBorderWidth();
  
  public abstract float getPadding();
  
  public abstract boolean getPaintFilterBitmap();
  
  public abstract float[] getRadii();
  
  public abstract boolean getScaleDownInsideBorders();
  
  public abstract boolean isCircle();
  
  public abstract void setBorder(int paramInt, float paramFloat);
  
  public abstract void setCircle(boolean paramBoolean);
  
  public abstract void setPadding(float paramFloat);
  
  public abstract void setPaintFilterBitmap(boolean paramBoolean);
  
  public abstract void setRadii(float[] paramArrayOfFloat);
  
  public abstract void setRadius(float paramFloat);
  
  public abstract void setScaleDownInsideBorders(boolean paramBoolean);
}
