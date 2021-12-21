package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

public class LPaint
  extends Paint
{
  public LPaint() {}
  
  public LPaint(int paramInt)
  {
    super(paramInt);
  }
  
  public LPaint(int paramInt, PorterDuff.Mode paramMode)
  {
    super(paramInt);
    setXfermode(new PorterDuffXfermode(paramMode));
  }
  
  public LPaint(PorterDuff.Mode paramMode)
  {
    setXfermode(new PorterDuffXfermode(paramMode));
  }
  
  public void setTextLocales(LocaleList paramLocaleList) {}
}
