package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class PixelUtil
{
  public PixelUtil() {}
  
  public static float getDisplayMetricDensity()
  {
    return getScreenDisplayMetricsdensity;
  }
  
  public static float toDIPFromPixel(float paramFloat)
  {
    return paramFloat / getWindowDisplayMetricsdensity;
  }
  
  public static float toPixelFromDIP(double paramDouble)
  {
    return toPixelFromDIP((float)paramDouble);
  }
  
  public static float toPixelFromDIP(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, DisplayMetricsHolder.getWindowDisplayMetrics());
  }
  
  public static float toPixelFromSP(double paramDouble)
  {
    return toPixelFromSP((float)paramDouble);
  }
  
  public static float toPixelFromSP(float paramFloat)
  {
    return toPixelFromSP(paramFloat, NaN.0F);
  }
  
  public static float toPixelFromSP(float paramFloat1, float paramFloat2)
  {
    DisplayMetrics localDisplayMetrics = DisplayMetricsHolder.getWindowDisplayMetrics();
    float f2 = scaledDensity;
    float f3 = f2 / density;
    float f1 = f2;
    if (paramFloat2 >= 1.0F)
    {
      f1 = f2;
      if (paramFloat2 < f3) {
        f1 = density * paramFloat2;
      }
    }
    return paramFloat1 * f1;
  }
  
  public static float toSPFromPixel(float paramFloat)
  {
    return paramFloat / getScreenDisplayMetricsscaledDensity;
  }
}
