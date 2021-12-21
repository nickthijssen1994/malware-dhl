package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;

class LayoutUpdateAnimation
  extends AbstractLayoutAnimation
{
  private static final boolean USE_TRANSLATE_ANIMATION = false;
  
  LayoutUpdateAnimation() {}
  
  Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramView.getX();
    float f2 = paramInt1;
    int j = 0;
    int i;
    if ((f1 == f2) && (paramView.getY() == paramInt2)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((paramView.getWidth() != paramInt3) || (paramView.getHeight() != paramInt4)) {
      j = 1;
    }
    if ((i == 0) && (j == 0)) {
      return null;
    }
    return new PositionAndSizeAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  boolean isValid()
  {
    return mDurationMs > 0;
  }
}
