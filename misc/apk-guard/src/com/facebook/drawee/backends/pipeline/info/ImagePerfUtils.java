package com.facebook.drawee.backends.pipeline.info;

public class ImagePerfUtils
{
  private ImagePerfUtils() {}
  
  public static String toString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 5: 
      return "error";
    case 4: 
      return "canceled";
    case 3: 
      return "success";
    case 2: 
      return "intermediate_available";
    case 1: 
      return "origin_available";
    }
    return "requested";
  }
}
