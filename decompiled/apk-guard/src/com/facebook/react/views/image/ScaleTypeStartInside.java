package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;

public class ScaleTypeStartInside
  extends ScalingUtils.AbstractScaleType
{
  public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeStartInside();
  
  public ScaleTypeStartInside() {}
  
  public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = Math.min(Math.min(paramFloat3, paramFloat4), 1.0F);
    paramFloat2 = left;
    paramFloat3 = top;
    paramMatrix.setScale(paramFloat1, paramFloat1);
    paramMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat3 + 0.5F));
  }
  
  public String toString()
  {
    return "start_inside";
  }
}
