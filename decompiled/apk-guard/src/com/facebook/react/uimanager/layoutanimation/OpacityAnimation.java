package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;

class OpacityAnimation
  extends Animation
{
  private final float mDeltaOpacity;
  private final float mStartOpacity;
  private final View mView;
  
  public OpacityAnimation(View paramView, float paramFloat1, float paramFloat2)
  {
    mView = paramView;
    mStartOpacity = paramFloat1;
    mDeltaOpacity = (paramFloat2 - paramFloat1);
    setAnimationListener(new OpacityAnimationListener(paramView));
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    mView.setAlpha(mStartOpacity + mDeltaOpacity * paramFloat);
  }
  
  public boolean willChangeBounds()
  {
    return false;
  }
  
  static class OpacityAnimationListener
    implements Animation.AnimationListener
  {
    private boolean mLayerTypeChanged = false;
    private final View mView;
    
    public OpacityAnimationListener(View paramView)
    {
      mView = paramView;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (mLayerTypeChanged) {
        mView.setLayerType(0, null);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if ((mView.hasOverlappingRendering()) && (mView.getLayerType() == 0))
      {
        mLayerTypeChanged = true;
        mView.setLayerType(2, null);
      }
    }
  }
}
