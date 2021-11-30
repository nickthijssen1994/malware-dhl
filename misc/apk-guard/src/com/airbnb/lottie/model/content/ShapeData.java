package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class ShapeData
{
  private boolean closed;
  private final List<CubicCurveData> curves;
  private PointF initialPoint;
  
  public ShapeData()
  {
    curves = new ArrayList();
  }
  
  public ShapeData(PointF paramPointF, boolean paramBoolean, List paramList)
  {
    initialPoint = paramPointF;
    closed = paramBoolean;
    curves = new ArrayList(paramList);
  }
  
  private void setInitialPoint(float paramFloat1, float paramFloat2)
  {
    if (initialPoint == null) {
      initialPoint = new PointF();
    }
    initialPoint.set(paramFloat1, paramFloat2);
  }
  
  public List getCurves()
  {
    return curves;
  }
  
  public PointF getInitialPoint()
  {
    return initialPoint;
  }
  
  public void interpolateBetween(ShapeData paramShapeData1, ShapeData paramShapeData2, float paramFloat)
  {
    if (initialPoint == null) {
      initialPoint = new PointF();
    }
    boolean bool;
    if ((!paramShapeData1.isClosed()) && (!paramShapeData2.isClosed())) {
      bool = false;
    } else {
      bool = true;
    }
    closed = bool;
    if (paramShapeData1.getCurves().size() != paramShapeData2.getCurves().size())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Curves must have the same number of control points. Shape 1: ");
      ((StringBuilder)localObject1).append(paramShapeData1.getCurves().size());
      ((StringBuilder)localObject1).append("\tShape 2: ");
      ((StringBuilder)localObject1).append(paramShapeData2.getCurves().size());
      Logger.warning(((StringBuilder)localObject1).toString());
    }
    int j = Math.min(paramShapeData1.getCurves().size(), paramShapeData2.getCurves().size());
    if (curves.size() < j)
    {
      i = curves.size();
      while (i < j)
      {
        curves.add(new CubicCurveData());
        i += 1;
      }
    }
    if (curves.size() > j)
    {
      i = curves.size() - 1;
      while (i >= j)
      {
        localObject1 = curves;
        ((List)localObject1).remove(((List)localObject1).size() - 1);
        i -= 1;
      }
    }
    Object localObject1 = paramShapeData1.getInitialPoint();
    PointF localPointF1 = paramShapeData2.getInitialPoint();
    setInitialPoint(MiscUtils.lerp(x, x, paramFloat), MiscUtils.lerp(y, y, paramFloat));
    int i = curves.size() - 1;
    while (i >= 0)
    {
      Object localObject3 = (CubicCurveData)paramShapeData1.getCurves().get(i);
      Object localObject2 = (CubicCurveData)paramShapeData2.getCurves().get(i);
      localObject1 = ((CubicCurveData)localObject3).getControlPoint1();
      localPointF1 = ((CubicCurveData)localObject3).getControlPoint2();
      localObject3 = ((CubicCurveData)localObject3).getVertex();
      PointF localPointF2 = ((CubicCurveData)localObject2).getControlPoint1();
      PointF localPointF3 = ((CubicCurveData)localObject2).getControlPoint2();
      localObject2 = ((CubicCurveData)localObject2).getVertex();
      ((CubicCurveData)curves.get(i)).setControlPoint1(MiscUtils.lerp(x, x, paramFloat), MiscUtils.lerp(y, y, paramFloat));
      ((CubicCurveData)curves.get(i)).setControlPoint2(MiscUtils.lerp(x, x, paramFloat), MiscUtils.lerp(y, y, paramFloat));
      ((CubicCurveData)curves.get(i)).setVertex(MiscUtils.lerp(x, x, paramFloat), MiscUtils.lerp(y, y, paramFloat));
      i -= 1;
    }
  }
  
  public boolean isClosed()
  {
    return closed;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeData{numCurves=");
    localStringBuilder.append(curves.size());
    localStringBuilder.append("closed=");
    localStringBuilder.append(closed);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
