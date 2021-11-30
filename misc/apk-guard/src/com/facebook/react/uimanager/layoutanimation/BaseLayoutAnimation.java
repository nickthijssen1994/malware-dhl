package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

abstract class BaseLayoutAnimation
  extends AbstractLayoutAnimation
{
  BaseLayoutAnimation() {}
  
  Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (mAnimatedProperty != null)
    {
      paramInt1 = 1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[mAnimatedProperty.ordinal()];
      float f2 = 0.0F;
      float f1;
      switch (paramInt1)
      {
      default: 
        paramView = new StringBuilder();
        paramView.append("Missing animation for property : ");
        paramView.append(mAnimatedProperty);
        throw new IllegalViewOperationException(paramView.toString());
      case 4: 
        if (isReverse()) {
          f1 = 1.0F;
        } else {
          f1 = 0.0F;
        }
        if (isReverse()) {
          f2 = 0.0F;
        } else {
          f2 = 1.0F;
        }
        return new ScaleAnimation(1.0F, 1.0F, f1, f2, 1, 0.0F, 1, 0.5F);
      case 3: 
        if (isReverse()) {
          f1 = 1.0F;
        } else {
          f1 = 0.0F;
        }
        if (isReverse()) {
          f2 = 0.0F;
        } else {
          f2 = 1.0F;
        }
        return new ScaleAnimation(f1, f2, 1.0F, 1.0F, 1, 0.5F, 1, 0.0F);
      case 2: 
        if (isReverse()) {
          f1 = 1.0F;
        } else {
          f1 = 0.0F;
        }
        if (isReverse()) {
          f2 = 0.0F;
        } else {
          f2 = 1.0F;
        }
        return new ScaleAnimation(f1, f2, f1, f2, 1, 0.5F, 1, 0.5F);
      }
      if (isReverse()) {
        f1 = paramView.getAlpha();
      } else {
        f1 = 0.0F;
      }
      if (!isReverse()) {
        f2 = paramView.getAlpha();
      }
      return new OpacityAnimation(paramView, f1, f2);
    }
    throw new IllegalViewOperationException("Missing animated property from animation config");
  }
  
  abstract boolean isReverse();
  
  boolean isValid()
  {
    return (mDurationMs > 0) && (mAnimatedProperty != null);
  }
}
