package com.facebook.imagepipeline.nativecode;

public class WebpTranscoderFactory
{
  private static WebpTranscoder sWebpTranscoder;
  public static boolean sWebpTranscoderPresent = false;
  
  static
  {
    try
    {
      sWebpTranscoder = (WebpTranscoder)Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
      sWebpTranscoderPresent = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public WebpTranscoderFactory() {}
  
  public static WebpTranscoder getWebpTranscoder()
  {
    return sWebpTranscoder;
  }
}
