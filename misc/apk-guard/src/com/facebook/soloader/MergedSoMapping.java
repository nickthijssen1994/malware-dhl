package com.facebook.soloader;

class MergedSoMapping
{
  MergedSoMapping() {}
  
  static void invokeJniOnload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown library: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static String mapLibName(String paramString)
  {
    return null;
  }
}
