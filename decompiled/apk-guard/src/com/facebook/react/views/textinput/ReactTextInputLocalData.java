package com.facebook.react.views.textinput;

import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.TextView;

public final class ReactTextInputLocalData
{
  private final int mBreakStrategy;
  private final int mInputType;
  private final int mMaxLines;
  private final int mMinLines;
  private final CharSequence mPlaceholder;
  private final SpannableStringBuilder mText;
  private final float mTextSize;
  
  public ReactTextInputLocalData(EditText paramEditText)
  {
    mText = new SpannableStringBuilder(paramEditText.getText());
    mTextSize = paramEditText.getTextSize();
    mInputType = paramEditText.getInputType();
    mPlaceholder = paramEditText.getHint();
    mMinLines = paramEditText.getMinLines();
    mMaxLines = paramEditText.getMaxLines();
    if (Build.VERSION.SDK_INT >= 23)
    {
      mBreakStrategy = paramEditText.getBreakStrategy();
      return;
    }
    mBreakStrategy = 0;
  }
  
  public void apply(EditText paramEditText)
  {
    paramEditText.setText(mText);
    paramEditText.setTextSize(0, mTextSize);
    paramEditText.setMinLines(mMinLines);
    paramEditText.setMaxLines(mMaxLines);
    paramEditText.setInputType(mInputType);
    paramEditText.setHint(mPlaceholder);
    if (Build.VERSION.SDK_INT >= 23) {
      paramEditText.setBreakStrategy(mBreakStrategy);
    }
  }
}
