package com.facebook.react.uimanager;

public class ReactRootViewTagGenerator
{
  private static final int ROOT_VIEW_TAG_INCREMENT = 10;
  private static int sNextRootViewTag;
  
  public ReactRootViewTagGenerator() {}
  
  public static int getNextRootViewTag()
  {
    try
    {
      int i = sNextRootViewTag;
      sNextRootViewTag += 10;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
