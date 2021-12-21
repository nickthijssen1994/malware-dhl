package com.facebook.common.media;

import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;

public class MediaUtils
{
  public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");
  
  public MediaUtils() {}
  
  private static String extractExtension(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if ((i >= 0) && (i != paramString.length() - 1)) {
      return paramString.substring(i + 1);
    }
    return null;
  }
  
  public static String extractMime(String paramString)
  {
    paramString = extractExtension(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    String str = MimeTypeMapWrapper.getMimeTypeFromExtension(paramString);
    if (str == null) {
      return (String)ADDITIONAL_ALLOWED_MIME_TYPES.get(paramString);
    }
    return str;
  }
  
  public static boolean isNonNativeSupportedMimeType(String paramString)
  {
    return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(paramString);
  }
  
  public static boolean isPhoto(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("image/"));
  }
  
  public static boolean isThreeD(String paramString)
  {
    return (paramString != null) && (paramString.equals("model/gltf-binary"));
  }
  
  public static boolean isVideo(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("video/"));
  }
}
