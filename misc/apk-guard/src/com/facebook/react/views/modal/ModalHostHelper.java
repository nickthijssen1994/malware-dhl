package com.facebook.react.views.modal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;

class ModalHostHelper
{
  private static final Point MAX_POINT = new Point();
  private static final Point MIN_POINT = new Point();
  private static final Point SIZE_POINT = new Point();
  
  ModalHostHelper() {}
  
  public static Point getModalHostSize(Context paramContext)
  {
    Display localDisplay = ((WindowManager)Assertions.assertNotNull((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay();
    localDisplay.getCurrentSizeRange(MIN_POINT, MAX_POINT);
    localDisplay.getSize(SIZE_POINT);
    int j = 0;
    boolean bool = paramContext.getTheme().obtainStyledAttributes(new int[] { 16843277 }).getBoolean(0, false);
    paramContext = paramContext.getResources();
    int k = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    int i = j;
    if (bool)
    {
      i = j;
      if (k > 0) {
        i = (int)paramContext.getDimension(k);
      }
    }
    if (SIZE_POINTx < SIZE_POINTy) {
      return new Point(MIN_POINTx, MAX_POINTy + i);
    }
    return new Point(MAX_POINTx, MIN_POINTy + i);
  }
}
