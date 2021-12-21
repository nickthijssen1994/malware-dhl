package com.facebook.react.common.network;

import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpCallUtil
{
  private OkHttpCallUtil() {}
  
  public static void cancelTag(OkHttpClient paramOkHttpClient, Object paramObject)
  {
    Object localObject = paramOkHttpClient.dispatcher().queuedCalls().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Call localCall = (Call)((Iterator)localObject).next();
      if (paramObject.equals(localCall.request().tag()))
      {
        localCall.cancel();
        return;
      }
    }
    paramOkHttpClient = paramOkHttpClient.dispatcher().runningCalls().iterator();
    while (paramOkHttpClient.hasNext())
    {
      localObject = (Call)paramOkHttpClient.next();
      if (paramObject.equals(((Call)localObject).request().tag())) {
        ((Call)localObject).cancel();
      }
    }
  }
}
