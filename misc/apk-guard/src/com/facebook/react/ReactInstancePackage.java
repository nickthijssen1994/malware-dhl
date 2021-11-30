package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;

@Deprecated
public abstract class ReactInstancePackage
  implements ReactPackage
{
  public ReactInstancePackage() {}
  
  public List createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    throw new RuntimeException("ReactInstancePackage must be passed in the ReactInstanceManager.");
  }
  
  public abstract List createNativeModules(ReactApplicationContext paramReactApplicationContext, ReactInstanceManager paramReactInstanceManager);
}
