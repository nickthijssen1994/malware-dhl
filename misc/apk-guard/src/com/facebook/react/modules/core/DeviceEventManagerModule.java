package com.facebook.react.modules.core;

import android.net.Uri;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="DeviceEventManager")
public class DeviceEventManagerModule
  extends ReactContextBaseJavaModule
{
  public static final String NAME = "DeviceEventManager";
  private final Runnable mInvokeDefaultBackPressRunnable;
  
  public DeviceEventManagerModule(ReactApplicationContext paramReactApplicationContext, final DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    super(paramReactApplicationContext);
    mInvokeDefaultBackPressRunnable = new Runnable()
    {
      public void run()
      {
        UiThreadUtil.assertOnUiThread();
        paramDefaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
      }
    };
  }
  
  public void emitHardwareBackPressed()
  {
    ((RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("hardwareBackPress", null);
  }
  
  public void emitNewIntentReceived(Uri paramUri)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("url", paramUri.toString());
    ((RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("url", localWritableMap);
  }
  
  public String getName()
  {
    return "DeviceEventManager";
  }
  
  public void invokeDefaultBackPressHandler()
  {
    getReactApplicationContext().runOnUiQueueThread(mInvokeDefaultBackPressRunnable);
  }
  
  public static abstract interface RCTDeviceEventEmitter
    extends JavaScriptModule
  {
    public abstract void emit(String paramString, Object paramObject);
  }
}
