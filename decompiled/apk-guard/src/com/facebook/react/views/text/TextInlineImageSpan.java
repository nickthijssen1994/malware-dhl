package com.facebook.react.views.text;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.widget.TextView;

public abstract class TextInlineImageSpan
  extends ReplacementSpan
  implements ReactSpan
{
  public TextInlineImageSpan() {}
  
  public static void possiblyUpdateInlineImageSpans(Spannable paramSpannable, TextView paramTextView)
  {
    int j = paramSpannable.length();
    int i = 0;
    paramSpannable = (TextInlineImageSpan[])paramSpannable.getSpans(0, j, TextInlineImageSpan.class);
    j = paramSpannable.length;
    while (i < j)
    {
      Object localObject = paramSpannable[i];
      localObject.onAttachedToWindow();
      localObject.setTextView(paramTextView);
      i += 1;
    }
  }
  
  public abstract Drawable getDrawable();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDetachedFromWindow();
  
  public abstract void onFinishTemporaryDetach();
  
  public abstract void onStartTemporaryDetach();
  
  public abstract void setTextView(TextView paramTextView);
}
