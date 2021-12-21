package com.airbnb.lottie.model;

public class Marker
{
  private static String CARRIAGE_RETURN;
  public final float durationFrames;
  private final String name;
  public final float startFrame;
  
  public Marker(String paramString, float paramFloat1, float paramFloat2)
  {
    name = paramString;
    durationFrames = paramFloat2;
    startFrame = paramFloat1;
  }
  
  public boolean matchesName(String paramString)
  {
    if (name.equalsIgnoreCase(paramString)) {
      return true;
    }
    if (name.endsWith(CARRIAGE_RETURN))
    {
      String str = name;
      if (str.substring(0, str.length() - 1).equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
}
