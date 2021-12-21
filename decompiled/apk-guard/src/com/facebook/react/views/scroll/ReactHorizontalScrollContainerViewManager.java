package com.facebook.react.views.scroll;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name="AndroidHorizontalScrollContentView")
public class ReactHorizontalScrollContainerViewManager
  extends ViewGroupManager<ReactHorizontalScrollContainerView>
{
  public static final String REACT_CLASS = "AndroidHorizontalScrollContentView";
  
  public ReactHorizontalScrollContainerViewManager() {}
  
  public ReactHorizontalScrollContainerView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactHorizontalScrollContainerView(paramThemedReactContext);
  }
  
  public String getName()
  {
    return "AndroidHorizontalScrollContentView";
  }
}
