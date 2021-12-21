package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BetterImageSpan
  extends ReplacementSpan
{
  public static final int ALIGN_BASELINE = 1;
  public static final int ALIGN_BOTTOM = 0;
  public static final int ALIGN_CENTER = 2;
  private final int mAlignment;
  private Rect mBounds;
  private final Drawable mDrawable;
  private final Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();
  private int mHeight;
  private int mWidth;
  
  public BetterImageSpan(Drawable paramDrawable)
  {
    this(paramDrawable, 1);
  }
  
  public BetterImageSpan(Drawable paramDrawable, int paramInt)
  {
    mDrawable = paramDrawable;
    mAlignment = paramInt;
    updateBounds();
  }
  
  private int getOffsetAboveBaseline(Paint.FontMetricsInt paramFontMetricsInt)
  {
    int i = mAlignment;
    if (i != 0)
    {
      if (i != 2) {
        return -mHeight;
      }
      i = (descent - ascent - mHeight) / 2;
      return ascent + i;
    }
    return descent - mHeight;
  }
  
  public static final int normalizeAlignment(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramPaint.getFontMetricsInt(mFontMetricsInt);
    paramInt1 = paramInt4 + getOffsetAboveBaseline(mFontMetricsInt);
    paramCanvas.translate(paramFloat, paramInt1);
    mDrawable.draw(paramCanvas);
    paramCanvas.translate(-paramFloat, -paramInt1);
  }
  
  public Drawable getDrawable()
  {
    return mDrawable;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    updateBounds();
    if (paramFontMetricsInt == null) {
      return mWidth;
    }
    paramInt1 = getOffsetAboveBaseline(paramFontMetricsInt);
    paramInt2 = mHeight + paramInt1;
    if (paramInt1 < ascent) {
      ascent = paramInt1;
    }
    if (paramInt1 < top) {
      top = paramInt1;
    }
    if (paramInt2 > descent) {
      descent = paramInt2;
    }
    if (paramInt2 > bottom) {
      bottom = paramInt2;
    }
    return mWidth;
  }
  
  public void updateBounds()
  {
    mBounds = mDrawable.getBounds();
    mWidth = mBounds.width();
    mHeight = mBounds.height();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BetterImageSpanAlignment {}
}
