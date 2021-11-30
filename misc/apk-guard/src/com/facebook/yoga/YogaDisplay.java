package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDisplay
{
  FLEX(0),  NONE(1);
  
  private final int mIntValue;
  
  private YogaDisplay(int paramInt)
  {
    mIntValue = paramInt;
  }
  
  public static YogaDisplay fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown enum value: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 1: 
      return NONE;
    }
    return FLEX;
  }
  
  public int intValue()
  {
    return mIntValue;
  }
}
