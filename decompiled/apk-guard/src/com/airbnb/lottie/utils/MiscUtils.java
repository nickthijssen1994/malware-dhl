package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class MiscUtils
{
  private static PointF pathFromDataCurrentPoint = new PointF();
  
  public MiscUtils() {}
  
  public static PointF addPoints(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(x + x, y + y);
  }
  
  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt3, paramInt1));
  }
  
  public static boolean contains(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= paramFloat2) && (paramFloat1 <= paramFloat3);
  }
  
  private static int floorDiv(int paramInt1, int paramInt2)
  {
    int j = paramInt1 / paramInt2;
    int i;
    if ((paramInt1 ^ paramInt2) >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (paramInt1 % paramInt2 != 0)) {
      return j - 1;
    }
    return j;
  }
  
  static int floorMod(float paramFloat1, float paramFloat2)
  {
    return floorMod((int)paramFloat1, (int)paramFloat2);
  }
  
  private static int floorMod(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2 * floorDiv(paramInt1, paramInt2);
  }
  
  public static void getPathFromData(ShapeData paramShapeData, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = paramShapeData.getInitialPoint();
    paramPath.moveTo(x, y);
    pathFromDataCurrentPoint.set(x, y);
    int i = 0;
    while (i < paramShapeData.getCurves().size())
    {
      Object localObject = (CubicCurveData)paramShapeData.getCurves().get(i);
      localPointF1 = ((CubicCurveData)localObject).getControlPoint1();
      PointF localPointF2 = ((CubicCurveData)localObject).getControlPoint2();
      localObject = ((CubicCurveData)localObject).getVertex();
      if ((localPointF1.equals(pathFromDataCurrentPoint)) && (localPointF2.equals(localObject))) {
        paramPath.lineTo(x, y);
      } else {
        paramPath.cubicTo(x, y, x, y, x, y);
      }
      pathFromDataCurrentPoint.set(x, y);
      i += 1;
    }
    if (paramShapeData.isClosed()) {
      paramPath.close();
    }
  }
  
  public static double lerp(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return paramDouble1 + paramDouble3 * (paramDouble2 - paramDouble1);
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  public static int lerp(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + paramFloat * (paramInt2 - paramInt1));
  }
  
  public static void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List paramList, KeyPath paramKeyPath2, KeyPathElementContent paramKeyPathElementContent)
  {
    if (paramKeyPath1.fullyResolvesTo(paramKeyPathElementContent.getName(), paramInt)) {
      paramList.add(paramKeyPath2.addKey(paramKeyPathElementContent.getName()).resolve(paramKeyPathElementContent));
    }
  }
}
