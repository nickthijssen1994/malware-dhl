package com.airbnb.lottie.parser.moshi;

final class JsonScope
{
  static final int CLOSED = 8;
  static final int DANGLING_NAME = 4;
  static final int EMPTY_ARRAY = 1;
  static final int EMPTY_DOCUMENT = 6;
  static final int EMPTY_OBJECT = 3;
  static final int NONEMPTY_ARRAY = 2;
  static final int NONEMPTY_DOCUMENT = 7;
  static final int NONEMPTY_OBJECT = 5;
  
  private JsonScope() {}
  
  static String getPath(int paramInt, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int i = 0;
    while (i < paramInt)
    {
      switch (paramArrayOfInt1[i])
      {
      default: 
        break;
      case 3: 
      case 4: 
      case 5: 
        localStringBuilder.append('.');
        if (paramArrayOfString[i] != null) {
          localStringBuilder.append(paramArrayOfString[i]);
        }
        break;
      case 1: 
      case 2: 
        localStringBuilder.append('[');
        localStringBuilder.append(paramArrayOfInt2[i]);
        localStringBuilder.append(']');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
