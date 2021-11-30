package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation
  extends BaseKeyframeAnimation<ShapeData, Path>
{
  private final Path tempPath = new Path();
  private final ShapeData tempShapeData = new ShapeData();
  
  public ShapeKeyframeAnimation(List paramList)
  {
    super(paramList);
  }
  
  public Path getValue(Keyframe paramKeyframe, float paramFloat)
  {
    ShapeData localShapeData = (ShapeData)startValue;
    paramKeyframe = (ShapeData)endValue;
    tempShapeData.interpolateBetween(localShapeData, paramKeyframe, paramFloat);
    MiscUtils.getPathFromData(tempShapeData, tempPath);
    return tempPath;
  }
}
