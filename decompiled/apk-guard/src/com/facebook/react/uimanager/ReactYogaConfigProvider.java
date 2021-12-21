package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConfig;

public class ReactYogaConfigProvider
{
  private static YogaConfig YOGA_CONFIG;
  
  public ReactYogaConfigProvider() {}
  
  public static YogaConfig blur()
  {
    if (YOGA_CONFIG == null)
    {
      YOGA_CONFIG = new YogaConfig();
      YOGA_CONFIG.setPointScaleFactor(0.0F);
      YOGA_CONFIG.setUseLegacyStretchBehaviour(true);
    }
    return YOGA_CONFIG;
  }
}
