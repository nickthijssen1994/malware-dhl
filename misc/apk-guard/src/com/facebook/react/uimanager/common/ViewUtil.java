package com.facebook.react.uimanager.common;

public class ViewUtil
{
  public ViewUtil() {}
  
  public static int getUIManagerType(int paramInt)
  {
    if (paramInt % 2 == 0) {
      return 2;
    }
    return 1;
  }
  
  public static boolean isRootTag(int paramInt)
  {
    return paramInt % 10 == 1;
  }
}
