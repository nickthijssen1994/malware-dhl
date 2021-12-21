package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ResourceDrawableIdHelper
{
  private static final String LOCAL_RESOURCE_SCHEME = "res";
  private static volatile ResourceDrawableIdHelper sResourceDrawableIdHelper;
  private Map<String, Integer> mResourceDrawableIdMap = new HashMap();
  
  private ResourceDrawableIdHelper() {}
  
  public static ResourceDrawableIdHelper getInstance()
  {
    if (sResourceDrawableIdHelper == null) {
      try
      {
        if (sResourceDrawableIdHelper == null) {
          sResourceDrawableIdHelper = new ResourceDrawableIdHelper();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return sResourceDrawableIdHelper;
  }
  
  public void clear()
  {
    try
    {
      mResourceDrawableIdMap.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Drawable getResourceDrawable(Context paramContext, String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0) {
      return paramContext.getResources().getDrawable(i);
    }
    return null;
  }
  
  public int getResourceDrawableId(Context paramContext, String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      paramString = paramString.toLowerCase().replace("-", "_");
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      for (;;) {}
    }
    try
    {
      if (mResourceDrawableIdMap.containsKey(paramString))
      {
        i = ((Integer)mResourceDrawableIdMap.get(paramString)).intValue();
        return i;
      }
      i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
      mResourceDrawableIdMap.put(paramString, Integer.valueOf(i));
      return i;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
    return 0;
  }
  
  public Uri getResourceDrawableUri(Context paramContext, String paramString)
  {
    int i = getResourceDrawableId(paramContext, paramString);
    if (i > 0) {
      return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }
    return Uri.EMPTY;
  }
}
