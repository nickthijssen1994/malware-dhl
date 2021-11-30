package com.facebook.yoga;

public class YogaMeasureOutput
{
  public YogaMeasureOutput() {}
  
  public static float getHeight(long paramLong)
  {
    return Float.intBitsToFloat((int)(paramLong & 0xFFFFFFFFFFFFFFFF));
  }
  
  public static float getWidth(long paramLong)
  {
    return Float.intBitsToFloat((int)(paramLong >> 32 & 0xFFFFFFFFFFFFFFFF));
  }
  
  public static long make(float paramFloat1, float paramFloat2)
  {
    int i = Float.floatToRawIntBits(paramFloat1);
    int j = Float.floatToRawIntBits(paramFloat2);
    long l = i;
    return j | l << 32;
  }
  
  public static long make(int paramInt1, int paramInt2)
  {
    return make(paramInt1, paramInt2);
  }
}
