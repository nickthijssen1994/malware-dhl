package com.facebook.react.uimanager;

public class FloatUtil
{
  private static final float EPSILON = 1.0E-5F;
  
  public FloatUtil() {}
  
  public static boolean floatsEqual(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2))) {
      return Math.abs(paramFloat2 - paramFloat1) < 1.0E-5F;
    }
    return (Float.isNaN(paramFloat1)) && (Float.isNaN(paramFloat2));
  }
}
