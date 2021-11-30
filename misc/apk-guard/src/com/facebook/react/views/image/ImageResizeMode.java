package com.facebook.react.views.image;

import android.graphics.Shader.TileMode;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

public class ImageResizeMode
{
  public ImageResizeMode() {}
  
  public static Shader.TileMode defaultTileMode()
  {
    return Shader.TileMode.CLAMP;
  }
  
  public static ScalingUtils.ScaleType defaultValue()
  {
    return ScalingUtils.ScaleType.CENTER_CROP;
  }
  
  public static ScalingUtils.ScaleType toScaleType(String paramString)
  {
    if ("contain".equals(paramString)) {
      return ScalingUtils.ScaleType.FIT_CENTER;
    }
    if ("cover".equals(paramString)) {
      return ScalingUtils.ScaleType.CENTER_CROP;
    }
    if ("stretch".equals(paramString)) {
      return ScalingUtils.ScaleType.FIT_XY;
    }
    if ("center".equals(paramString)) {
      return ScalingUtils.ScaleType.CENTER_INSIDE;
    }
    if ("repeat".equals(paramString)) {
      return ScaleTypeStartInside.INSTANCE;
    }
    if (paramString == null) {
      return defaultValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid resize mode: '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    throw new JSApplicationIllegalArgumentException(localStringBuilder.toString());
  }
  
  public static Shader.TileMode toTileMode(String paramString)
  {
    if ((!"contain".equals(paramString)) && (!"cover".equals(paramString)) && (!"stretch".equals(paramString)) && (!"center".equals(paramString)))
    {
      if ("repeat".equals(paramString)) {
        return Shader.TileMode.REPEAT;
      }
      if (paramString == null) {
        return defaultTileMode();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid resize mode: '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      throw new JSApplicationIllegalArgumentException(localStringBuilder.toString());
    }
    return Shader.TileMode.CLAMP;
  }
}
