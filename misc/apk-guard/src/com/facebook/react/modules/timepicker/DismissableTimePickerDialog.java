package com.facebook.react.modules.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Build.VERSION;

public class DismissableTimePickerDialog
  extends TimePickerDialog
{
  public DismissableTimePickerDialog(Context paramContext, int paramInt1, TimePickerDialog.OnTimeSetListener paramOnTimeSetListener, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramContext, paramInt1, paramOnTimeSetListener, paramInt2, paramInt3, paramBoolean);
  }
  
  public DismissableTimePickerDialog(Context paramContext, TimePickerDialog.OnTimeSetListener paramOnTimeSetListener, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramOnTimeSetListener, paramInt1, paramInt2, paramBoolean);
  }
  
  protected void onStop()
  {
    if (Build.VERSION.SDK_INT > 19) {
      super.onStop();
    }
  }
}
