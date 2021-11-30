package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaNodeType
{
  DEFAULT(0),  TEXT(1);
  
  private final int mIntValue;
  
  private YogaNodeType(int paramInt)
  {
    mIntValue = paramInt;
  }
  
  public static YogaNodeType fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown enum value: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 1: 
      return TEXT;
    }
    return DEFAULT;
  }
  
  public int intValue()
  {
    return mIntValue;
  }
}
