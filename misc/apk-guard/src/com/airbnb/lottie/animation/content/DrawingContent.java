package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

public abstract interface DrawingContent
  extends Content
{
  public abstract void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  public abstract void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean);
}
