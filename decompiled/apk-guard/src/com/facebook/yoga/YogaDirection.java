package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDirection
{
  INHERIT(0),  LEFT(1),  RIGHT(2);
  
  private final int mIntValue;
  
  private YogaDirection(int paramInt)
  {
    mIntValue = paramInt;
  }
  
  public static YogaDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown enum value: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 2: 
      return RIGHT;
    case 1: 
      return LEFT;
    }
    return INHERIT;
  }
  
  public int intValue()
  {
    return mIntValue;
  }
}
