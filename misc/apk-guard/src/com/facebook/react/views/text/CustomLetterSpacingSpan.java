package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

@TargetApi(21)
public class CustomLetterSpacingSpan
  extends MetricAffectingSpan
  implements ReactSpan
{
  private final float mLetterSpacing;
  
  public CustomLetterSpacingSpan(float paramFloat)
  {
    mLetterSpacing = paramFloat;
  }
  
  private void apply(TextPaint paramTextPaint)
  {
    if (!Float.isNaN(mLetterSpacing)) {
      paramTextPaint.setLetterSpacing(mLetterSpacing);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint);
  }
}
