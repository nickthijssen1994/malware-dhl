package com.facebook.imageformat;

import javax.annotation.Nullable;

public class ImageFormat
{
  public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
  @Nullable
  private final String mFileExtension;
  private final String mName;
  
  public ImageFormat(String paramString1, String paramString2)
  {
    mName = paramString1;
    mFileExtension = paramString2;
  }
  
  public String getFileExtension()
  {
    return mFileExtension;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String toString()
  {
    return getName();
  }
  
  public static abstract interface FormatChecker
  {
    public abstract ImageFormat determineFormat(byte[] paramArrayOfByte, int paramInt);
    
    public abstract int getHeaderSize();
  }
}
