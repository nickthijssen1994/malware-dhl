package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;

public abstract interface ReactPackage
{
  public abstract List createNativeModules(ReactApplicationContext paramReactApplicationContext);
  
  public abstract List createViewManagers(ReactApplicationContext paramReactApplicationContext);
}
