package com.facebook.react.views.view;

import android.view.View.MeasureSpec;
import com.facebook.yoga.YogaMeasureMode;

public class MeasureUtil
{
  public MeasureUtil() {}
  
  public static int getMeasureSpec(float paramFloat, YogaMeasureMode paramYogaMeasureMode)
  {
    if (paramYogaMeasureMode == YogaMeasureMode.EXACTLY) {
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, 1073741824);
    }
    if (paramYogaMeasureMode == YogaMeasureMode.AT_MOST) {
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, Integer.MIN_VALUE);
    }
    return View.MeasureSpec.makeMeasureSpec(0, 0);
  }
}
