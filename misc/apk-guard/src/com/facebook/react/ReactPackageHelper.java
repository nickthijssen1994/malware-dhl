package com.facebook.react;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;
import java.util.List;

public class ReactPackageHelper
{
  public ReactPackageHelper() {}
  
  public static Iterable getNativeModuleIterator(ReactPackage paramReactPackage, ReactApplicationContext paramReactApplicationContext, ReactInstanceManager paramReactInstanceManager)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramReactPackage.getClass().getSimpleName());
    localStringBuilder.append(" is not a LazyReactPackage, falling back to old version.");
    FLog.d("ReactNative", localStringBuilder.toString());
    if ((paramReactPackage instanceof ReactInstancePackage)) {
      paramReactPackage = ((ReactInstancePackage)paramReactPackage).createNativeModules(paramReactApplicationContext, paramReactInstanceManager);
    } else {
      paramReactPackage = paramReactPackage.createNativeModules(paramReactApplicationContext);
    }
    new Iterable()
    {
      public Iterator iterator()
      {
        new Iterator()
        {
          int position = 0;
          
          public boolean hasNext()
          {
            return position < val$nativeModules.size();
          }
          
          public ModuleHolder next()
          {
            List localList = val$nativeModules;
            int i = position;
            position = (i + 1);
            return new ModuleHolder((NativeModule)localList.get(i));
          }
          
          public void remove()
          {
            throw new UnsupportedOperationException("Cannot remove methods ");
          }
        };
      }
    };
  }
}
