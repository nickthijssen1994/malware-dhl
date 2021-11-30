package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

@ReactModule(name="RCTRawText")
public class ReactRawTextManager
  extends ViewManager<View, ReactRawTextShadowNode>
{
  @VisibleForTesting
  public static final String REACT_CLASS = "RCTRawText";
  
  public ReactRawTextManager() {}
  
  public ReactRawTextShadowNode createShadowNodeInstance()
  {
    return new ReactRawTextShadowNode();
  }
  
  public ReactTextView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new IllegalStateException("Attempt to create a native view for RCTRawText");
  }
  
  public String getName()
  {
    return "RCTRawText";
  }
  
  public Class getShadowNodeClass()
  {
    return ReactRawTextShadowNode.class;
  }
  
  public void updateExtraData(View paramView, Object paramObject) {}
}
