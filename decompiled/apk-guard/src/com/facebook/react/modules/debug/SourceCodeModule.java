package com.facebook.react.modules.debug;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name="SourceCode")
public class SourceCodeModule
  extends BaseJavaModule
{
  public static final String NAME = "SourceCode";
  private final ReactContext mReactContext;
  
  public SourceCodeModule(ReactContext paramReactContext)
  {
    mReactContext = paramReactContext;
  }
  
  public Map getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("scriptURL", (String)Assertions.assertNotNull(mReactContext.getCatalystInstance().getSourceURL(), "No source URL loaded, have you initialised the instance?"));
    return localHashMap;
  }
  
  public String getName()
  {
    return "SourceCode";
  }
}
