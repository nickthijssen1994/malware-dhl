package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaExperimentalFeature
{
  WEB_FLEX_BASIS(0);
  
  private final int mIntValue;
  
  private YogaExperimentalFeature(int paramInt)
  {
    mIntValue = paramInt;
  }
  
  public static YogaExperimentalFeature fromInt(int paramInt)
  {
    if (paramInt == 0) {
      return WEB_FLEX_BASIS;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown enum value: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int intValue()
  {
    return mIntValue;
  }
}
