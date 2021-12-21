package com.facebook.react.views.picker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="AndroidDropdownPicker")
public class ReactDropdownPickerManager
  extends ReactPickerManager
{
  public static final String REACT_CLASS = "AndroidDropdownPicker";
  
  public ReactDropdownPickerManager() {}
  
  protected ReactPicker createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactPicker(paramThemedReactContext, 1);
  }
  
  public String getName()
  {
    return "AndroidDropdownPicker";
  }
}
