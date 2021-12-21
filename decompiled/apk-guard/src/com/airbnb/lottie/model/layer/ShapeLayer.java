package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

public class ShapeLayer
  extends BaseLayer
{
  private final ContentGroup contentGroup;
  
  ShapeLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    super(paramLottieDrawable, paramLayer);
    contentGroup = new ContentGroup(paramLottieDrawable, this, new ShapeGroup("__container", paramLayer.getShapes(), false));
    contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    contentGroup.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    contentGroup.getBounds(paramRectF, boundsMatrix, paramBoolean);
  }
  
  protected void resolveChildKeyPath(KeyPath paramKeyPath1, int paramInt, List paramList, KeyPath paramKeyPath2)
  {
    contentGroup.resolveKeyPath(paramKeyPath1, paramInt, paramList, paramKeyPath2);
  }
}
