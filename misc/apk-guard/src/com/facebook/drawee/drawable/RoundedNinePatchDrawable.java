package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class RoundedNinePatchDrawable
  extends RoundedDrawable
{
  public RoundedNinePatchDrawable(NinePatchDrawable paramNinePatchDrawable)
  {
    super(paramNinePatchDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("RoundedNinePatchDrawable#draw");
    }
    if (!shouldRound())
    {
      super.draw(paramCanvas);
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
    else
    {
      updateTransform();
      updatePath();
      paramCanvas.clipPath(mPath);
      super.draw(paramCanvas);
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
}
