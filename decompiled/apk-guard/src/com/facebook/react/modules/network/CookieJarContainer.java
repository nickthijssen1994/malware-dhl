package com.facebook.react.modules.network;

import okhttp3.CookieJar;

public abstract interface CookieJarContainer
  extends CookieJar
{
  public abstract void removeCookieJar();
  
  public abstract void setCookieJar(CookieJar paramCookieJar);
}
