package com.facebook.react.views.picker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="AndroidDialogPicker")
public class ReactDialogPickerManager
  extends ReactPickerManager
{
  public static final String REACT_CLASS = "AndroidDialogPicker";
  
  public ReactDialogPickerManager() {}
  
  protected ReactPicker createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactPicker(paramThemedReactContext, 0);
  }
  
  public String getName()
  {
    return "AndroidDialogPicker";
  }
}
