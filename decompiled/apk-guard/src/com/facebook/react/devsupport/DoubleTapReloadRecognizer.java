package com.facebook.react.devsupport;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class DoubleTapReloadRecognizer
{
  private static final long DOUBLE_TAP_DELAY = 200L;
  private boolean mDoRefresh = false;
  
  public DoubleTapReloadRecognizer() {}
  
  public boolean didDoubleTapR(int paramInt, View paramView)
  {
    if ((paramInt == 46) && (!(paramView instanceof EditText)))
    {
      if (mDoRefresh)
      {
        mDoRefresh = false;
        return true;
      }
      mDoRefresh = true;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          DoubleTapReloadRecognizer.access$002(DoubleTapReloadRecognizer.this, false);
        }
      }, 200L);
    }
    return false;
  }
}
