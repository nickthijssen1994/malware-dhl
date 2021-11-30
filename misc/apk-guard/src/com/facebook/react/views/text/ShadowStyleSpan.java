package com.facebook.react.views.text;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

public class ShadowStyleSpan
  extends CharacterStyle
  implements ReactSpan
{
  private final int mColor;
  private final float mHeight;
  private final float mPadding;
  private final float mRadius;
  
  public ShadowStyleSpan(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    mHeight = paramFloat1;
    mPadding = paramFloat2;
    mRadius = paramFloat3;
    mColor = paramInt;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setShadowLayer(mRadius, mHeight, mPadding, mColor);
  }
}
