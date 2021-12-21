package com.facebook.yoga;

public class YogaConstants
{
  public static final float UNDEFINED = NaN.0F;
  
  public YogaConstants() {}
  
  public static float getUndefined()
  {
    return NaN.0F;
  }
  
  public static boolean isUndefined(float paramFloat)
  {
    return Float.compare(paramFloat, NaN.0F) == 0;
  }
  
  public static boolean isUndefined(YogaValue paramYogaValue)
  {
    return unit == YogaUnit.UNDEFINED;
  }
}
