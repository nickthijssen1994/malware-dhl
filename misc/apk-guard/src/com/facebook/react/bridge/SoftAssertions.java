package com.facebook.react.bridge;

public class SoftAssertions
{
  public SoftAssertions() {}
  
  public static void assertCondition(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionException(paramString);
  }
  
  public static Object assertNotNull(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new AssertionException("Expected object to not be null!");
  }
  
  public static void assertUnreachable(String paramString)
  {
    throw new AssertionException(paramString);
  }
}
