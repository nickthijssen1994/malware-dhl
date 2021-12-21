package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;

public abstract class RequestOnlyHandler
  implements RequestHandler
{
  private static final String CLASS_TAG = JSPackagerClient.class.getSimpleName();
  
  public RequestOnlyHandler() {}
  
  public final void onNotification(Object paramObject)
  {
    FLog.e(CLASS_TAG, "Notification is not supported");
  }
  
  public abstract void onRequest(Object paramObject, Responder paramResponder);
}
