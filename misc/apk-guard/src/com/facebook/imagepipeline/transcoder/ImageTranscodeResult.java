package com.facebook.imagepipeline.transcoder;

public class ImageTranscodeResult
{
  private final int mTranscodeStatus;
  
  public ImageTranscodeResult(int paramInt)
  {
    mTranscodeStatus = paramInt;
  }
  
  public int getTranscodeStatus()
  {
    return mTranscodeStatus;
  }
  
  public String toString()
  {
    return String.format(null, "Status: %d", new Object[] { Integer.valueOf(mTranscodeStatus) });
  }
}
