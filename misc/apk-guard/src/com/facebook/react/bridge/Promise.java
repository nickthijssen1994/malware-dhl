package com.facebook.react.bridge;

public abstract interface Promise
{
  public abstract void reject(String paramString);
  
  public abstract void reject(String paramString, WritableMap paramWritableMap);
  
  public abstract void reject(String paramString1, String paramString2);
  
  public abstract void reject(String paramString1, String paramString2, WritableMap paramWritableMap);
  
  public abstract void reject(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void reject(String paramString1, String paramString2, Throwable paramThrowable, WritableMap paramWritableMap);
  
  public abstract void reject(String paramString, Throwable paramThrowable);
  
  public abstract void reject(String paramString, Throwable paramThrowable, WritableMap paramWritableMap);
  
  public abstract void reject(Throwable paramThrowable);
  
  public abstract void reject(Throwable paramThrowable, WritableMap paramWritableMap);
  
  public abstract void resolve(Object paramObject);
}
