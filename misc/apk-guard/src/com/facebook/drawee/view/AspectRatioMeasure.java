package com.facebook.drawee.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;

public class AspectRatioMeasure
{
  public AspectRatioMeasure() {}
  
  private static boolean shouldAdjust(int paramInt)
  {
    return (paramInt == 0) || (paramInt == -2);
  }
  
  public static void updateMeasureSpec(Spec paramSpec, float paramFloat, ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    if (paramFloat > 0.0F)
    {
      if (paramLayoutParams == null) {
        return;
      }
      if (shouldAdjust(height))
      {
        height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int)((View.MeasureSpec.getSize(width) - paramInt1) / paramFloat + paramInt2), height), 1073741824);
        return;
      }
      if (shouldAdjust(width)) {
        width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int)((View.MeasureSpec.getSize(height) - paramInt2) * paramFloat + paramInt1), width), 1073741824);
      }
    }
  }
  
  public static class Spec
  {
    public int height;
    public int width;
    
    public Spec() {}
  }
}
