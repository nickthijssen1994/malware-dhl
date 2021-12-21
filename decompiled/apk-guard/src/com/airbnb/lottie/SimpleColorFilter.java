package com.airbnb.lottie;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

public class SimpleColorFilter
  extends PorterDuffColorFilter
{
  public SimpleColorFilter(int paramInt)
  {
    super(paramInt, PorterDuff.Mode.SRC_ATOP);
  }
}
