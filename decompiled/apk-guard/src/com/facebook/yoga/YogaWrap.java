package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaWrap
{
  NO_WRAP(0),  WRAP(1),  WRAP_REVERSE(2);
  
  private final int mIntValue;
  
  private YogaWrap(int paramInt)
  {
    mIntValue = paramInt;
  }
  
  public static YogaWrap fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown enum value: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 2: 
      return WRAP_REVERSE;
    case 1: 
      return WRAP;
    }
    return NO_WRAP;
  }
  
  public int intValue()
  {
    return mIntValue;
  }
}
