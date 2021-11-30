package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NativeModuleRegistry
{
  private final Map<String, ModuleHolder> mModules;
  private final ReactApplicationContext mReactApplicationContext;
  
  public NativeModuleRegistry(ReactApplicationContext paramReactApplicationContext, Map paramMap)
  {
    mReactApplicationContext = paramReactApplicationContext;
    mModules = paramMap;
  }
  
  private Map getModuleMap()
  {
    return mModules;
  }
  
  private ReactApplicationContext getReactApplicationContext()
  {
    return mReactApplicationContext;
  }
  
  public List getAllModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = mModules.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ModuleHolder)localIterator.next()).getModule());
    }
    return localArrayList;
  }
  
  Collection getCxxModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = mModules.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ModuleHolder)localEntry.getValue()).isCxxModule()) {
        localArrayList.add(localEntry.getValue());
      }
    }
    return localArrayList;
  }
  
  Collection getJavaModules(JSInstance paramJSInstance)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = mModules.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((ModuleHolder)localEntry.getValue()).isCxxModule()) {
        localArrayList.add(new JavaModuleWrapper(paramJSInstance, (ModuleHolder)localEntry.getValue()));
      }
    }
    return localArrayList;
  }
  
  public NativeModule getModule(Class paramClass)
  {
    Object localObject1 = (ReactModule)paramClass.getAnnotation(ReactModule.class);
    if (localObject1 != null)
    {
      Object localObject2 = mModules.get(((ReactModule)localObject1).name());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((ReactModule)localObject1).name());
      localStringBuilder.append(" could not be found. Is it defined in ");
      localStringBuilder.append(paramClass.getName());
      return ((ModuleHolder)Assertions.assertNotNull(localObject2, localStringBuilder.toString())).getModule();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Could not find @ReactModule annotation in class ");
    ((StringBuilder)localObject1).append(paramClass.getName());
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public NativeModule getModule(String paramString)
  {
    Object localObject = mModules.get(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not find module with name ");
    localStringBuilder.append(paramString);
    return ((ModuleHolder)Assertions.assertNotNull(localObject, localStringBuilder.toString())).getModule();
  }
  
  public boolean hasModule(Class paramClass)
  {
    paramClass = ((ReactModule)paramClass.getAnnotation(ReactModule.class)).name();
    return mModules.containsKey(paramClass);
  }
  
  public boolean hasModule(String paramString)
  {
    return mModules.containsKey(paramString);
  }
  
  void notifyJSInstanceDestroy()
  {
    mReactApplicationContext.assertOnNativeModulesQueueThread();
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyJSInstanceDestroy");
    try
    {
      Iterator localIterator = mModules.values().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        ((ModuleHolder)localIterator.next()).destroy();
      }
      Systrace.endSection(0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      Systrace.endSection(0L);
      throw localThrowable;
    }
  }
  
  void notifyJSInstanceInitialized()
  {
    mReactApplicationContext.assertOnNativeModulesQueueThread("From version React Native v0.44, native modules are explicitly not initialized on the UI thread. See https://github.com/facebook/react-native/wiki/Breaking-Changes#d4611211-reactnativeandroidbreaking-move-nativemodule-initialization-off-ui-thread---aaachiuuu  for more details.");
    ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_START);
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyJSInstanceInitialized");
    try
    {
      Iterator localIterator = mModules.values().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        ((ModuleHolder)localIterator.next()).markInitializable();
      }
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
      return;
    }
    catch (Throwable localThrowable)
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
      throw localThrowable;
    }
  }
  
  public void onBatchComplete()
  {
    ModuleHolder localModuleHolder = (ModuleHolder)mModules.get("UIManager");
    if ((localModuleHolder != null) && (localModuleHolder.hasInstance())) {
      ((OnBatchCompleteListener)localModuleHolder.getModule()).onBatchComplete();
    }
  }
  
  void registerModules(NativeModuleRegistry paramNativeModuleRegistry)
  {
    Assertions.assertCondition(mReactApplicationContext.equals(paramNativeModuleRegistry.getReactApplicationContext()), "Extending native modules with non-matching application contexts.");
    paramNativeModuleRegistry = paramNativeModuleRegistry.getModuleMap().entrySet().iterator();
    while (paramNativeModuleRegistry.hasNext())
    {
      Object localObject = (Map.Entry)paramNativeModuleRegistry.next();
      String str = (String)((Map.Entry)localObject).getKey();
      if (!mModules.containsKey(str))
      {
        localObject = (ModuleHolder)((Map.Entry)localObject).getValue();
        mModules.put(str, localObject);
      }
    }
  }
}
