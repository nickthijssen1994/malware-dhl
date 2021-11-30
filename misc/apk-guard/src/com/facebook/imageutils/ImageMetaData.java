package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import javax.annotation.Nullable;

public class ImageMetaData
{
  @Nullable
  private final ColorSpace mColorSpace;
  @Nullable
  private final Pair<Integer, Integer> mDimensions;
  
  public ImageMetaData(int paramInt1, int paramInt2, ColorSpace paramColorSpace)
  {
    Pair localPair;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      localPair = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    } else {
      localPair = null;
    }
    mDimensions = localPair;
    mColorSpace = paramColorSpace;
  }
  
  public ColorSpace getColorSpace()
  {
    return mColorSpace;
  }
  
  public Pair getDimensions()
  {
    return mDimensions;
  }
}
