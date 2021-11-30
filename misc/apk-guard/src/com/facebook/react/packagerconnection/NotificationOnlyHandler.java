package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;

public abstract class NotificationOnlyHandler
  implements RequestHandler
{
  private static final String CLASS_TAG = JSPackagerClient.class.getSimpleName();
  
  public NotificationOnlyHandler() {}
  
  public abstract void onNotification(Object paramObject);
  
  public final void onRequest(Object paramObject, Responder paramResponder)
  {
    paramResponder.error("Request is not supported");
    FLog.e(CLASS_TAG, "Request is not supported");
  }
}
