package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ReactModule(name="I18nManager")
public class I18nManagerModule
  extends ContextBaseJavaModule
{
  public static final String NAME = "I18nManager";
  private final I18nUtil sharedI18nUtilInstance = I18nUtil.getInstance();
  
  public I18nManagerModule(Context paramContext)
  {
    super(paramContext);
  }
  
  public void allowRTL(boolean paramBoolean)
  {
    sharedI18nUtilInstance.allowRTL(getContext(), paramBoolean);
  }
  
  public void forceRTL(boolean paramBoolean)
  {
    sharedI18nUtilInstance.forceRTL(getContext(), paramBoolean);
  }
  
  public Map getConstants()
  {
    Context localContext = getContext();
    Locale localLocale = getResourcesgetConfigurationlocale;
    HashMap localHashMap = MapBuilder.newHashMap();
    localHashMap.put("isRTL", Boolean.valueOf(sharedI18nUtilInstance.isRTL(localContext)));
    localHashMap.put("doLeftAndRightSwapInRTL", Boolean.valueOf(sharedI18nUtilInstance.doLeftAndRightSwapInRTL(localContext)));
    localHashMap.put("localeIdentifier", localLocale.toString());
    return localHashMap;
  }
  
  public String getName()
  {
    return "I18nManager";
  }
  
  public void swapLeftAndRightInRTL(boolean paramBoolean)
  {
    sharedI18nUtilInstance.swapLeftAndRightInRTL(getContext(), paramBoolean);
  }
}
