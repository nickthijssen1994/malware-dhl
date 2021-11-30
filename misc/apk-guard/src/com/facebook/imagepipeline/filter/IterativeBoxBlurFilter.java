package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;

public abstract class IterativeBoxBlurFilter
{
  private static final String PAGE_KEY = "IterativeBoxBlurFilter";
  
  public IterativeBoxBlurFilter() {}
  
  private static int bound(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static void boxBlurBitmapInPlace(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramBitmap);
    Preconditions.checkArgument(paramBitmap.isMutable());
    boolean bool;
    if (paramBitmap.getHeight() <= 2048.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if (paramBitmap.getWidth() <= 2048.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((paramInt2 > 0) && (paramInt2 <= 25)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    try
    {
      fastBoxBlur(paramBitmap, paramInt1, paramInt2);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      FLog.e("IterativeBoxBlurFilter", String.format(null, "OOM: %d iterations on %dx%d with %d radius", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramInt2) }));
      throw localOutOfMemoryError;
    }
  }
  
  private static void fastBoxBlur(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[m * n];
    paramBitmap.getPixels(arrayOfInt1, 0, m, 0, 0, m, n);
    int i = paramInt2 + 1;
    int i1 = i + paramInt2;
    int[] arrayOfInt2 = new int[i1 * 256];
    paramInt2 = 1;
    for (;;)
    {
      j = 0;
      if (paramInt2 > 255) {
        break;
      }
      while (j < i1)
      {
        arrayOfInt2[i] = paramInt2;
        i += 1;
        j += 1;
      }
      paramInt2 += 1;
    }
    int[] arrayOfInt3 = new int[Math.max(m, n)];
    int j = 0;
    while (j < paramInt1)
    {
      paramInt2 = 0;
      while (paramInt2 < n)
      {
        internalHorizontalBlur(arrayOfInt1, arrayOfInt3, m, paramInt2, i1, arrayOfInt2);
        System.arraycopy(arrayOfInt3, 0, arrayOfInt1, paramInt2 * m, m);
        paramInt2 += 1;
      }
      paramInt2 = 0;
      while (paramInt2 < m)
      {
        internalVerticalBlur(arrayOfInt1, arrayOfInt3, m, n, paramInt2, i1, arrayOfInt2);
        int k = 0;
        i = paramInt2;
        while (k < n)
        {
          arrayOfInt1[i] = arrayOfInt3[k];
          i += m;
          k += 1;
        }
        paramInt2 += 1;
      }
      j += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, m, 0, 0, m, n);
  }
  
  private static void internalHorizontalBlur(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt3)
  {
    int i4 = paramInt1 * paramInt2;
    int i5 = (paramInt2 + 1) * paramInt1 - 1;
    int i6 = paramInt3 >> 1;
    int m = -i6;
    int k = 0;
    int j = 0;
    int i = 0;
    paramInt2 = 0;
    while (m < paramInt1 + i6)
    {
      int i3 = paramArrayOfInt1[bound(i4 + m, i4, i5)];
      int n = k + (i3 >> 16 & 0xFF);
      int i1 = j + (i3 >> 8 & 0xFF);
      int i2 = i + (i3 & 0xFF);
      i3 = paramInt2 + (i3 >>> 24);
      k = n;
      j = i1;
      i = i2;
      paramInt2 = i3;
      if (m >= i6)
      {
        paramArrayOfInt2[(m - i6)] = (paramArrayOfInt3[i3] << 24 | paramArrayOfInt3[n] << 16 | paramArrayOfInt3[i1] << 8 | paramArrayOfInt3[i2]);
        paramInt2 = paramArrayOfInt1[bound(m - (paramInt3 - 1) + i4, i4, i5)];
        k = n - (paramInt2 >> 16 & 0xFF);
        j = i1 - (paramInt2 >> 8 & 0xFF);
        i = i2 - (paramInt2 & 0xFF);
        paramInt2 = i3 - (paramInt2 >>> 24);
      }
      m += 1;
    }
  }
  
  private static void internalVerticalBlur(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt3)
  {
    int i6 = (paramInt2 - 1) * paramInt1 + paramInt3;
    int i7 = (paramInt4 >> 1) * paramInt1;
    int m = paramInt3 - i7;
    int k = 0;
    int j = 0;
    int i = 0;
    paramInt2 = 0;
    int i1;
    for (int n = 0; m <= i6 + i7; n = i1)
    {
      i1 = paramArrayOfInt1[bound(m, paramInt3, i6)];
      int i2 = k + (i1 >> 16 & 0xFF);
      int i3 = j + (i1 >> 8 & 0xFF);
      int i4 = i + (i1 & 0xFF);
      int i5 = paramInt2 + (i1 >>> 24);
      k = i2;
      j = i3;
      i = i4;
      paramInt2 = i5;
      i1 = n;
      if (m - i7 >= paramInt3)
      {
        paramArrayOfInt2[n] = (paramArrayOfInt3[i5] << 24 | paramArrayOfInt3[i2] << 16 | paramArrayOfInt3[i3] << 8 | paramArrayOfInt3[i4]);
        i1 = n + 1;
        paramInt2 = paramArrayOfInt1[bound(m - (paramInt4 - 1) * paramInt1, paramInt3, i6)];
        k = i2 - (paramInt2 >> 16 & 0xFF);
        j = i3 - (paramInt2 >> 8 & 0xFF);
        i = i4 - (paramInt2 & 0xFF);
        paramInt2 = i5 - (paramInt2 >>> 24);
      }
      m += paramInt1;
    }
  }
}
