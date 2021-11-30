package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;

public abstract class TurboReactPackage
  implements ReactPackage
{
  public TurboReactPackage() {}
  
  public List createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    throw new UnsupportedOperationException("In case of TurboModules, createNativeModules is not supported. NativeModuleRegistry should instead use getModuleList or getModule method");
  }
  
  public List createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    Object localObject = getViewManagers(paramReactApplicationContext);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramReactApplicationContext = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramReactApplicationContext.add((ViewManager)((ModuleSpec)((Iterator)localObject).next()).getProvider().get());
      }
      return paramReactApplicationContext;
    }
    return Collections.emptyList();
  }
  
  public abstract NativeModule getModule(String paramString, ReactApplicationContext paramReactApplicationContext);
  
  public Iterable getNativeModuleIterator(final ReactApplicationContext paramReactApplicationContext)
  {
    new Iterable()
    {
      public Iterator iterator()
      {
        new Iterator()
        {
          public boolean hasNext()
          {
            return val$entrySetIterator.hasNext();
          }
          
          public ModuleHolder next()
          {
            Map.Entry localEntry = (Map.Entry)val$entrySetIterator.next();
            String str = (String)localEntry.getKey();
            return new ModuleHolder((ReactModuleInfo)localEntry.getValue(), new TurboReactPackage.ModuleHolderProvider(TurboReactPackage.this, str, val$reactContext));
          }
          
          public void remove()
          {
            throw new UnsupportedOperationException("Cannot remove native modules from the list");
          }
        };
      }
    };
  }
  
  public abstract ReactModuleInfoProvider getReactModuleInfoProvider();
  
  protected List getViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return Collections.emptyList();
  }
  
  private class ModuleHolderProvider
    implements Provider<NativeModule>
  {
    private final String mName;
    private final ReactApplicationContext mReactContext;
    
    public ModuleHolderProvider(String paramString, ReactApplicationContext paramReactApplicationContext)
    {
      mName = paramString;
      mReactContext = paramReactApplicationContext;
    }
    
    public NativeModule get()
    {
      return getModule(mName, mReactContext);
    }
  }
}
