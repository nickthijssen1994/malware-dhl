package com.facebook.react.packagerconnection;

public abstract interface RequestHandler
{
  public abstract void onNotification(Object paramObject);
  
  public abstract void onRequest(Object paramObject, Responder paramResponder);
}
