package com.facebook.react.modules.network;

public class HeaderUtil
{
  public HeaderUtil() {}
  
  public static String stripHeaderName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      char c = paramString.charAt(i);
      if ((c > ' ') && (c < '')) {
        localStringBuilder.append(c);
      } else {
        j = 1;
      }
      i += 1;
    }
    if (j != 0) {
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  public static String stripHeaderValue(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      char c = paramString.charAt(i);
      if (((c > '\037') && (c < '')) || (c == '\t')) {
        localStringBuilder.append(c);
      } else {
        j = 1;
      }
      i += 1;
    }
    if (j != 0) {
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
}
