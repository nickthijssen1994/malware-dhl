package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;

public abstract interface ViewManagerOnDemandReactPackage
{
  public abstract ViewManager createViewManager(ReactApplicationContext paramReactApplicationContext, String paramString);
  
  public abstract List getViewManagerNames(ReactApplicationContext paramReactApplicationContext);
}
