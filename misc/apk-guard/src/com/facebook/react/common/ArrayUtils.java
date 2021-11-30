package com.facebook.react.common;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils
{
  public ArrayUtils() {}
  
  public static float[] copyArray(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    return Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
  }
  
  public static int[] copyListToArray(List paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
}
