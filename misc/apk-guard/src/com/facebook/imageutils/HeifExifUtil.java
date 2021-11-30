package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.soloader.DoNotOptimize;
import java.io.IOException;
import java.io.InputStream;

public class HeifExifUtil
{
  public static final String PAGE_KEY = "HeifExifUtil";
  
  public HeifExifUtil() {}
  
  public static int getOrientation(InputStream paramInputStream)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return HeifExifUtilAndroidN.getOrientation(paramInputStream);
    }
    FLog.d("HeifExifUtil", "Trying to read Heif Exif information before Android N -> ignoring");
    return 0;
  }
  
  @DoNotOptimize
  private static class HeifExifUtilAndroidN
  {
    private HeifExifUtilAndroidN() {}
    
    static int getOrientation(InputStream paramInputStream)
    {
      try
      {
        int i = new ExifInterface(paramInputStream).getAttributeInt("Orientation", 1);
        return i;
      }
      catch (IOException paramInputStream)
      {
        FLog.d("HeifExifUtil", "Failed reading Heif Exif orientation -> ignoring", paramInputStream);
      }
      return 0;
    }
  }
}
