package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class PositionAndSizeAnimation
  extends Animation
  implements LayoutHandlingAnimation
{
  private int mDeltaHeight;
  private int mDeltaWidth;
  private float mDeltaX;
  private float mDeltaY;
  private int mStartHeight;
  private int mStartWidth;
  private float mStartX;
  private float mStartY;
  private final View mView;
  
  public PositionAndSizeAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mView = paramView;
    calculateAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void calculateAnimation(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mStartX = (mView.getX() - mView.getTranslationX());
    mStartY = (mView.getY() - mView.getTranslationY());
    mStartWidth = mView.getWidth();
    mStartHeight = mView.getHeight();
    mDeltaX = (paramInt1 - mStartX);
    mDeltaY = (paramInt2 - mStartY);
    mDeltaWidth = (paramInt3 - mStartWidth);
    mDeltaHeight = (paramInt4 - mStartHeight);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = mStartX + mDeltaX * paramFloat;
    float f2 = mStartY + mDeltaY * paramFloat;
    float f3 = mStartWidth;
    float f4 = mDeltaWidth;
    float f5 = mStartHeight;
    float f6 = mDeltaHeight;
    mView.layout(Math.round(f1), Math.round(f2), Math.round(f1 + (f3 + f4 * paramFloat)), Math.round(f2 + (f5 + f6 * paramFloat)));
  }
  
  public void onLayoutUpdate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    calculateAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}
