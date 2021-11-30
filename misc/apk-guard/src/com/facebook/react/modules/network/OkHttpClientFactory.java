package com.facebook.react.modules.network;

import okhttp3.OkHttpClient;

public abstract interface OkHttpClientFactory
{
  public abstract OkHttpClient createNewNetworkModuleClient();
}
