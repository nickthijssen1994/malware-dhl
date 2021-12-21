package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

public final class InPlaceRoundFilter
{
  private InPlaceRoundFilter() {}
  
  public static void roundBitmapInPlace(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    int i5 = paramBitmap.getWidth();
    int i6 = paramBitmap.getHeight();
    int i7 = Math.min(i5, i6) / 2;
    int i9 = i5 / 2;
    int i8 = i6 / 2;
    if (i7 == 0) {
      return;
    }
    boolean bool;
    if (i7 >= 1) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((i5 > 0) && (i5 <= 2048.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((i6 > 0) && (i6 <= 2048.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((i9 > 0) && (i9 < i5)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((i8 > 0) && (i8 < i6)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    int[] arrayOfInt1 = new int[i5 * i6];
    paramBitmap.getPixels(arrayOfInt1, 0, i5, 0, 0, i5, i6);
    int m = i7 - 1;
    if ((i9 - m >= 0) && (i8 - m >= 0) && (i9 + m < i5) && (i8 + m < i6)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    int i10 = -i7 * 2;
    int[] arrayOfInt2 = new int[i5];
    int i = i10 + 1;
    int i1 = 0;
    int k = 1;
    int n = 1;
    while (m >= i1)
    {
      int i2 = i9 + m;
      int i3 = i9 - m;
      int j = i9 + i1;
      int i4 = i9 - i1;
      int i11 = i8 + i1;
      int i12 = i8 - i1;
      if ((m >= 0) && (j < i5) && (i4 >= 0) && (i11 < i6) && (i12 >= 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      i11 *= i5;
      int i14 = i5 * i12;
      i12 = i5 * (i8 + m);
      int i13 = i5 * (i8 - m);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i11, i3);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i14, i3);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i12, i4);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i13, i4);
      i3 = i5 - i2;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i11 + i2, i3);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i14 + i2, i3);
      i2 = i5 - j;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i12 + j, i2);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i13 + j, i2);
      j = i;
      i3 = i1;
      i2 = n;
      if (i <= 0)
      {
        i3 = i1 + 1;
        i2 = n + 2;
        j = i + i2;
      }
      i = j;
      n = m;
      i4 = k;
      if (j > 0)
      {
        n = m - 1;
        i4 = k + 2;
        i = j + (i4 + i10);
      }
      m = n;
      i1 = i3;
      n = i2;
      k = i4;
    }
    i = i8 - i7;
    while (i >= 0)
    {
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i * i5, i5);
      i -= 1;
    }
    i = i8 + i7;
    while (i < i6)
    {
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i * i5, i5);
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i5, 0, 0, i5, i6);
  }
}
