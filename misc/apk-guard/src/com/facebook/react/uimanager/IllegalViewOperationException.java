package com.facebook.react.uimanager;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.JSApplicationCausedNativeException;

public class IllegalViewOperationException
  extends JSApplicationCausedNativeException
{
  @Nullable
  private View mView;
  
  public IllegalViewOperationException(String paramString)
  {
    super(paramString);
  }
  
  public IllegalViewOperationException(String paramString, View paramView, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    mView = paramView;
  }
  
  public View getView()
  {
    return mView;
  }
}
