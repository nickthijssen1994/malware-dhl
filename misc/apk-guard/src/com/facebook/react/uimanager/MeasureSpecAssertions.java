package com.facebook.react.uimanager;

import android.view.View.MeasureSpec;

public class MeasureSpecAssertions
{
  public MeasureSpecAssertions() {}
  
  public static final void assertExplicitMeasureSpec(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      return;
    }
    throw new IllegalStateException("A catalyst view must have an explicit width and height given to it. This should normally happen as part of the standard catalyst UI framework.");
  }
}
