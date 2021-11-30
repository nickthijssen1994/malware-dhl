package com.facebook.react.views.common;

import android.content.Context;
import android.content.ContextWrapper;

public class ContextUtils
{
  public ContextUtils() {}
  
  public static Object findContextOfType(Context paramContext, Class paramClass)
  {
    while (!paramClass.isInstance(paramContext)) {
      if ((paramContext instanceof ContextWrapper))
      {
        Context localContext = ((ContextWrapper)paramContext).getBaseContext();
        if (paramContext == localContext) {
          return null;
        }
        paramContext = localContext;
      }
      else
      {
        return null;
      }
    }
    return paramContext;
  }
}
