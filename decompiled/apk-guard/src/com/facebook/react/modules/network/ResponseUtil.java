package com.facebook.react.modules.network;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.net.SocketTimeoutException;

public class ResponseUtil
{
  public ResponseUtil() {}
  
  public static void onDataReceived(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, WritableMap paramWritableMap)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushMap(paramWritableMap);
    paramRCTDeviceEventEmitter.emit("didReceiveNetworkData", localWritableArray);
  }
  
  public static void onDataReceived(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, String paramString)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushString(paramString);
    paramRCTDeviceEventEmitter.emit("didReceiveNetworkData", localWritableArray);
  }
  
  public static void onDataReceivedProgress(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, long paramLong1, long paramLong2)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushInt((int)paramLong1);
    localWritableArray.pushInt((int)paramLong2);
    paramRCTDeviceEventEmitter.emit("didReceiveNetworkDataProgress", localWritableArray);
  }
  
  public static void onDataSend(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, long paramLong1, long paramLong2)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushInt((int)paramLong1);
    localWritableArray.pushInt((int)paramLong2);
    paramRCTDeviceEventEmitter.emit("didSendNetworkData", localWritableArray);
  }
  
  public static void onIncrementalDataReceived(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushString(paramString);
    localWritableArray.pushInt((int)paramLong1);
    localWritableArray.pushInt((int)paramLong2);
    paramRCTDeviceEventEmitter.emit("didReceiveNetworkIncrementalData", localWritableArray);
  }
  
  public static void onRequestError(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, String paramString, Throwable paramThrowable)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushString(paramString);
    if ((paramThrowable != null) && (paramThrowable.getClass() == SocketTimeoutException.class)) {
      localWritableArray.pushBoolean(true);
    }
    paramRCTDeviceEventEmitter.emit("didCompleteNetworkResponse", localWritableArray);
  }
  
  public static void onRequestSuccess(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt);
    localWritableArray.pushNull();
    paramRCTDeviceEventEmitter.emit("didCompleteNetworkResponse", localWritableArray);
  }
  
  public static void onResponseReceived(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt1, int paramInt2, WritableMap paramWritableMap, String paramString)
  {
    WritableArray localWritableArray = Arguments.createArray();
    localWritableArray.pushInt(paramInt1);
    localWritableArray.pushInt(paramInt2);
    localWritableArray.pushMap(paramWritableMap);
    localWritableArray.pushString(paramString);
    paramRCTDeviceEventEmitter.emit("didReceiveNetworkResponse", localWritableArray);
  }
}
