package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.infer.annotation.Assertions;

public class RootViewUtil
{
  public RootViewUtil() {}
  
  public static RootView getRootView(View paramView)
  {
    for (;;)
    {
      if ((paramView instanceof RootView)) {
        return (RootView)paramView;
      }
      paramView = paramView.getParent();
      if (paramView == null) {
        return null;
      }
      Assertions.assertCondition(paramView instanceof View);
      paramView = (View)paramView;
    }
  }
}
