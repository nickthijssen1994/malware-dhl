package com.airbnb.lottie.value;

public class ScaleXY
{
  private float scaleX;
  private float scaleY;
  
  public ScaleXY()
  {
    this(1.0F, 1.0F);
  }
  
  public ScaleXY(float paramFloat1, float paramFloat2)
  {
    scaleX = paramFloat1;
    scaleY = paramFloat2;
  }
  
  public boolean equals(float paramFloat1, float paramFloat2)
  {
    return (scaleX == paramFloat1) && (scaleY == paramFloat2);
  }
  
  public float getScaleX()
  {
    return scaleX;
  }
  
  public float getScaleY()
  {
    return scaleY;
  }
  
  public void set(float paramFloat1, float paramFloat2)
  {
    scaleX = paramFloat1;
    scaleY = paramFloat2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getScaleX());
    localStringBuilder.append("x");
    localStringBuilder.append(getScaleY());
    return localStringBuilder.toString();
  }
}
