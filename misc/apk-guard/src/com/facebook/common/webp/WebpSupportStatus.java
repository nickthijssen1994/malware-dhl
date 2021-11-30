package com.facebook.common.webp;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;

public class WebpSupportStatus
{
  private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
  private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
  private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
  private static final byte[] WEBP_NAME_BYTES;
  private static final byte[] WEBP_RIFF_BYTES;
  private static final byte[] WEBP_VP8L_BYTES = asciiBytes("VP8L");
  private static final byte[] WEBP_VP8X_BYTES = asciiBytes("VP8X");
  private static final byte[] WEBP_VP8_BYTES;
  public static final boolean sIsExtendedWebpSupported;
  public static final boolean sIsSimpleWebpSupported;
  public static final boolean sIsWebpSupportRequired;
  @Nullable
  public static WebpBitmapFactory sWebpBitmapFactory;
  private static boolean sWebpLibraryChecked;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1;
    if (i <= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    sIsWebpSupportRequired = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    sIsSimpleWebpSupported = bool1;
    sIsExtendedWebpSupported = isExtendedWebpSupported();
    sWebpBitmapFactory = null;
    sWebpLibraryChecked = false;
    WEBP_RIFF_BYTES = asciiBytes("RIFF");
    WEBP_NAME_BYTES = asciiBytes("WEBP");
    WEBP_VP8_BYTES = asciiBytes("VP8 ");
  }
  
  public WebpSupportStatus() {}
  
  private static byte[] asciiBytes(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII not found!", paramString);
    }
  }
  
  public static boolean isAnimatedWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8X_BYTES);
    if ((paramArrayOfByte[(paramInt + 20)] & 0x2) == 2) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    return (bool) && (paramInt != 0);
  }
  
  public static boolean isExtendedWebpHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 21) && (matchBytePattern(paramArrayOfByte, paramInt1 + 12, WEBP_VP8X_BYTES));
  }
  
  public static boolean isExtendedWebpHeaderWithAlpha(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8X_BYTES);
    if ((paramArrayOfByte[(paramInt + 20)] & 0x10) == 16) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    return (bool) && (paramInt != 0);
  }
  
  private static boolean isExtendedWebpSupported()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    if (Build.VERSION.SDK_INT == 17)
    {
      byte[] arrayOfByte = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      if (outHeight == 1)
      {
        if (outWidth == 1) {
          break label69;
        }
        return false;
      }
    }
    else
    {
      return true;
    }
    return false;
    label69:
    return true;
  }
  
  public static boolean isLosslessWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    return matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8L_BYTES);
  }
  
  public static boolean isSimpleWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    return matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8_BYTES);
  }
  
  public static boolean isWebpHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 20) && (matchBytePattern(paramArrayOfByte, paramInt1, WEBP_RIFF_BYTES)) && (matchBytePattern(paramArrayOfByte, paramInt1 + 8, WEBP_NAME_BYTES));
  }
  
  public static boolean isWebpSupportedByPlatform(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (isSimpleWebpHeader(paramArrayOfByte, paramInt1)) {
      return sIsSimpleWebpSupported;
    }
    if (isLosslessWebpHeader(paramArrayOfByte, paramInt1)) {
      return sIsExtendedWebpSupported;
    }
    if (isExtendedWebpHeader(paramArrayOfByte, paramInt1, paramInt2))
    {
      if (isAnimatedWebpHeader(paramArrayOfByte, paramInt1)) {
        return false;
      }
      return sIsExtendedWebpSupported;
    }
    return false;
  }
  
  public static WebpBitmapFactory loadWebpBitmapFactoryIfExists()
  {
    if (sWebpLibraryChecked) {
      return sWebpBitmapFactory;
    }
    Object localObject = null;
    try
    {
      WebpBitmapFactory localWebpBitmapFactory = (WebpBitmapFactory)Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
      localObject = localWebpBitmapFactory;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    sWebpLibraryChecked = true;
    return localObject;
  }
  
  private static boolean matchBytePattern(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 != null)
    {
      if (paramArrayOfByte1 == null) {
        return false;
      }
      if (paramArrayOfByte2.length + paramInt > paramArrayOfByte1.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[(i + paramInt)] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
}
