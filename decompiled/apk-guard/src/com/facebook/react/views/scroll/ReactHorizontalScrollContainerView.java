package com.facebook.react.views.scroll;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

public class ReactHorizontalScrollContainerView
  extends ViewGroup
{
  private int mCurrentWidth;
  private int mLayoutDirection;
  
  public ReactHorizontalScrollContainerView(Context paramContext) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (mLayoutDirection == 1)
    {
      setLeft(0);
      setRight(paramInt3 - paramInt1 + 0);
      HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)getParent();
      localHorizontalScrollView.scrollTo(localHorizontalScrollView.getScrollX() + getWidth() - mCurrentWidth, localHorizontalScrollView.getScrollY());
    }
    mCurrentWidth = getWidth();
  }
}
