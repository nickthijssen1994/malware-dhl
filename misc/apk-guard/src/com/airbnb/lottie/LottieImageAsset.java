package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

public class LottieImageAsset
{
  @Nullable
  private Bitmap bitmap;
  private final String dirName;
  private final String fileName;
  private final int height;
  private final String id;
  private final int width;
  
  public LottieImageAsset(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    width = paramInt1;
    height = paramInt2;
    id = paramString1;
    fileName = paramString2;
    dirName = paramString3;
  }
  
  public Bitmap getBitmap()
  {
    return bitmap;
  }
  
  public String getDirName()
  {
    return dirName;
  }
  
  public String getFileName()
  {
    return fileName;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public String getId()
  {
    return id;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    bitmap = paramBitmap;
  }
}
