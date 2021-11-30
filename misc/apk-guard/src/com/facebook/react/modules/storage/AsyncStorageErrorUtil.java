package com.facebook.react.modules.storage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class AsyncStorageErrorUtil
{
  public AsyncStorageErrorUtil() {}
  
  static WritableMap getDBError(String paramString)
  {
    return getError(paramString, "Database Error");
  }
  
  static WritableMap getError(String paramString1, String paramString2)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("message", paramString2);
    if (paramString1 != null) {
      localWritableMap.putString("key", paramString1);
    }
    return localWritableMap;
  }
  
  static WritableMap getInvalidKeyError(String paramString)
  {
    return getError(paramString, "Invalid key");
  }
  
  static WritableMap getInvalidValueError(String paramString)
  {
    return getError(paramString, "Invalid Value");
  }
}
