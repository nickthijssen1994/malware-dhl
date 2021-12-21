package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class CubicCurveData
{
  private final PointF controlPoint1;
  private final PointF controlPoint2;
  private final PointF vertex;
  
  public CubicCurveData()
  {
    controlPoint1 = new PointF();
    controlPoint2 = new PointF();
    vertex = new PointF();
  }
  
  public CubicCurveData(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    controlPoint1 = paramPointF1;
    controlPoint2 = paramPointF2;
    vertex = paramPointF3;
  }
  
  public PointF getControlPoint1()
  {
    return controlPoint1;
  }
  
  public PointF getControlPoint2()
  {
    return controlPoint2;
  }
  
  public PointF getVertex()
  {
    return vertex;
  }
  
  public void setControlPoint1(float paramFloat1, float paramFloat2)
  {
    controlPoint1.set(paramFloat1, paramFloat2);
  }
  
  public void setControlPoint2(float paramFloat1, float paramFloat2)
  {
    controlPoint2.set(paramFloat1, paramFloat2);
  }
  
  public void setVertex(float paramFloat1, float paramFloat2)
  {
    vertex.set(paramFloat1, paramFloat2);
  }
}
