package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeContent
  implements PathContent, BaseKeyframeAnimation.AnimationListener
{
  private final boolean hidden;
  private boolean isPathValid;
  private final LottieDrawable lottieDrawable;
  private final String name;
  private final Path path = new Path();
  private final BaseKeyframeAnimation<?, Path> shapeAnimation;
  private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
  
  public ShapeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapePath paramShapePath)
  {
    name = paramShapePath.getName();
    hidden = paramShapePath.isHidden();
    lottieDrawable = paramLottieDrawable;
    shapeAnimation = paramShapePath.getShapePath().createAnimation();
    paramBaseLayer.addAnimation(shapeAnimation);
    shapeAnimation.addUpdateListener(this);
  }
  
  private void invalidate()
  {
    isPathValid = false;
    lottieDrawable.invalidateSelf();
  }
  
  public String getName()
  {
    return name;
  }
  
  public Path getPath()
  {
    if (isPathValid) {
      return path;
    }
    path.reset();
    if (hidden)
    {
      isPathValid = true;
      return path;
    }
    path.set((Path)shapeAnimation.getValue());
    path.setFillType(Path.FillType.EVEN_ODD);
    trimPaths.apply(path);
    isPathValid = true;
    return path;
  }
  
  public void onValueChanged()
  {
    invalidate();
  }
  
  public void setContents(List paramList1, List paramList2)
  {
    int i = 0;
    while (i < paramList1.size())
    {
      paramList2 = (Content)paramList1.get(i);
      if ((paramList2 instanceof TrimPathContent))
      {
        paramList2 = (TrimPathContent)paramList2;
        if (paramList2.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY)
        {
          trimPaths.addTrimPath(paramList2);
          paramList2.addListener(this);
        }
      }
      i += 1;
    }
  }
}
