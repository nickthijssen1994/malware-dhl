package com.facebook.react.bridge.queue;

public abstract interface ReactQueueConfiguration
{
  public abstract void destroy();
  
  public abstract MessageQueueThread getJSQueueThread();
  
  public abstract MessageQueueThread getNativeModulesQueueThread();
  
  public abstract MessageQueueThread getUIQueueThread();
}
