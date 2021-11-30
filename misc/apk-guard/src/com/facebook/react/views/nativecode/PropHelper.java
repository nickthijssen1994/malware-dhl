package com.facebook.react.views.nativecode;

import com.facebook.react.bridge.ReadableArray;

class PropHelper
{
  PropHelper() {}
  
  static int toFloatArray(ReadableArray paramReadableArray, float[] paramArrayOfFloat)
  {
    int i;
    if (paramReadableArray.size() > paramArrayOfFloat.length) {
      i = paramArrayOfFloat.length;
    } else {
      i = paramReadableArray.size();
    }
    int j = 0;
    while (j < i)
    {
      paramArrayOfFloat[j] = ((float)paramReadableArray.getDouble(j));
      j += 1;
    }
    return paramReadableArray.size();
  }
  
  static float[] toFloatArray(ReadableArray paramReadableArray)
  {
    if (paramReadableArray != null)
    {
      float[] arrayOfFloat = new float[paramReadableArray.size()];
      toFloatArray(paramReadableArray, arrayOfFloat);
      return arrayOfFloat;
    }
    return null;
  }
}
