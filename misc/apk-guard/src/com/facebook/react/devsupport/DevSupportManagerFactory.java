package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import java.lang.reflect.Constructor;
import java.util.Map;

public class DevSupportManagerFactory
{
  private static final String DEVSUPPORT_IMPL_CLASS = "DevSupportManagerImpl";
  private static final String DEVSUPPORT_IMPL_PACKAGE = "com.facebook.react.devsupport";
  
  public DevSupportManagerFactory() {}
  
  public static DevSupportManager create(Context paramContext, ReactInstanceManagerDevHelper paramReactInstanceManagerDevHelper, String paramString, boolean paramBoolean, int paramInt)
  {
    return create(paramContext, paramReactInstanceManagerDevHelper, paramString, paramBoolean, null, null, paramInt, null);
  }
  
  public static DevSupportManager create(Context paramContext, ReactInstanceManagerDevHelper paramReactInstanceManagerDevHelper, String paramString, boolean paramBoolean, RedBoxHandler paramRedBoxHandler, DevBundleDownloadListener paramDevBundleDownloadListener, int paramInt, Map paramMap)
  {
    if (!paramBoolean) {
      return new DisabledDevSupportManager();
    }
    try
    {
      Object localObject = new StringBuilder("com.facebook.react.devsupport");
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append("DevSupportManagerImpl");
      localObject = Class.forName(((StringBuilder)localObject).toString());
      Class localClass1 = Boolean.TYPE;
      Class localClass2 = Integer.TYPE;
      localObject = ((Class)localObject).getConstructor(new Class[] { Context.class, ReactInstanceManagerDevHelper.class, String.class, localClass1, RedBoxHandler.class, DevBundleDownloadListener.class, localClass2, Map.class });
      paramContext = ((Constructor)localObject).newInstance(new Object[] { paramContext, paramReactInstanceManagerDevHelper, paramString, Boolean.valueOf(true), paramRedBoxHandler, paramDevBundleDownloadListener, Integer.valueOf(paramInt), paramMap });
      return (DevSupportManager)paramContext;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", paramContext);
    }
  }
}
