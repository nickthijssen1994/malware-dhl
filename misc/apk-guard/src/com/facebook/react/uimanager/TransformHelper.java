package com.facebook.react.uimanager;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

public class TransformHelper
{
  private static ThreadLocal<double[]> sHelperMatrix = new ThreadLocal()
  {
    protected double[] initialValue()
    {
      return new double[16];
    }
  };
  
  public TransformHelper() {}
  
  private static double convertToRadians(ReadableMap paramReadableMap, String paramString)
  {
    ReadableType localReadableType1 = paramReadableMap.getType(paramString);
    ReadableType localReadableType2 = ReadableType.String;
    int j = 1;
    int i = 1;
    double d;
    if (localReadableType1 == localReadableType2)
    {
      paramString = paramReadableMap.getString(paramString);
      paramReadableMap = paramString;
      if (paramString.endsWith("rad"))
      {
        paramReadableMap = paramString.substring(0, paramString.length() - 3);
      }
      else if (paramString.endsWith("deg"))
      {
        paramReadableMap = paramString.substring(0, paramString.length() - 3);
        i = 0;
      }
      d = Float.parseFloat(paramReadableMap);
    }
    else
    {
      d = paramReadableMap.getDouble(paramString);
      i = j;
    }
    if (i != 0) {
      return d;
    }
    return MatrixMathHelper.degreesToRadians(d);
  }
  
  public static void processTransform(ReadableArray paramReadableArray, double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = (double[])sHelperMatrix.get();
    MatrixMathHelper.resetIdentityMatrix(paramArrayOfDouble);
    int k = paramReadableArray.size();
    int i = 0;
    while (i < k)
    {
      ReadableMap localReadableMap = paramReadableArray.getMap(i);
      Object localObject = localReadableMap.keySetIterator().nextKey();
      MatrixMathHelper.resetIdentityMatrix(arrayOfDouble);
      if ("matrix".equals(localObject))
      {
        localObject = localReadableMap.getArray((String)localObject);
        int j = 0;
        while (j < 16)
        {
          arrayOfDouble[j] = ((ReadableArray)localObject).getDouble(j);
          j += 1;
        }
      }
      if ("perspective".equals(localObject))
      {
        MatrixMathHelper.applyPerspective(arrayOfDouble, localReadableMap.getDouble((String)localObject));
      }
      else if ("rotateX".equals(localObject))
      {
        MatrixMathHelper.applyRotateX(arrayOfDouble, convertToRadians(localReadableMap, (String)localObject));
      }
      else if ("rotateY".equals(localObject))
      {
        MatrixMathHelper.applyRotateY(arrayOfDouble, convertToRadians(localReadableMap, (String)localObject));
      }
      else if ((!"rotate".equals(localObject)) && (!"rotateZ".equals(localObject)))
      {
        double d1;
        if ("scale".equals(localObject))
        {
          d1 = localReadableMap.getDouble((String)localObject);
          MatrixMathHelper.applyScaleX(arrayOfDouble, d1);
          MatrixMathHelper.applyScaleY(arrayOfDouble, d1);
        }
        else if ("scaleX".equals(localObject))
        {
          MatrixMathHelper.applyScaleX(arrayOfDouble, localReadableMap.getDouble((String)localObject));
        }
        else if ("scaleY".equals(localObject))
        {
          MatrixMathHelper.applyScaleY(arrayOfDouble, localReadableMap.getDouble((String)localObject));
        }
        else
        {
          boolean bool = "translate".equals(localObject);
          d1 = 0.0D;
          if (bool)
          {
            localObject = localReadableMap.getArray((String)localObject);
            double d2 = ((ReadableArray)localObject).getDouble(0);
            double d3 = ((ReadableArray)localObject).getDouble(1);
            if (((ReadableArray)localObject).size() > 2) {
              d1 = ((ReadableArray)localObject).getDouble(2);
            }
            MatrixMathHelper.applyTranslate3D(arrayOfDouble, d2, d3, d1);
          }
          else if ("translateX".equals(localObject))
          {
            MatrixMathHelper.applyTranslate2D(arrayOfDouble, localReadableMap.getDouble((String)localObject), 0.0D);
          }
          else if ("translateY".equals(localObject))
          {
            MatrixMathHelper.applyTranslate2D(arrayOfDouble, 0.0D, localReadableMap.getDouble((String)localObject));
          }
          else if ("skewX".equals(localObject))
          {
            MatrixMathHelper.applySkewX(arrayOfDouble, convertToRadians(localReadableMap, (String)localObject));
          }
          else if ("skewY".equals(localObject))
          {
            MatrixMathHelper.applySkewY(arrayOfDouble, convertToRadians(localReadableMap, (String)localObject));
          }
          else
          {
            paramReadableArray = new StringBuilder();
            paramReadableArray.append("Unsupported transform type: ");
            paramReadableArray.append((String)localObject);
            throw new JSApplicationIllegalArgumentException(paramReadableArray.toString());
          }
        }
      }
      else
      {
        MatrixMathHelper.applyRotateZ(arrayOfDouble, convertToRadians(localReadableMap, (String)localObject));
      }
      MatrixMathHelper.multiplyInto(paramArrayOfDouble, paramArrayOfDouble, arrayOfDouble);
      i += 1;
    }
  }
}
