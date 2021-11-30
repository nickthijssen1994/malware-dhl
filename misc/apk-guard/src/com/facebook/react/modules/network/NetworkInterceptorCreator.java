package com.facebook.react.modules.network;

import okhttp3.Interceptor;

public abstract interface NetworkInterceptorCreator
{
  public abstract Interceptor create();
}
