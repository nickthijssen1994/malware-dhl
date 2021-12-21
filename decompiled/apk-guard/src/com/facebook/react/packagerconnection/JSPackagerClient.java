package com.facebook.react.packagerconnection;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import java.util.Map;
import okio.ByteString;
import org.json.JSONObject;

public final class JSPackagerClient
  implements ReconnectingWebSocket.MessageCallback
{
  private static final String PACKAGER_CONNECTION_URL_FORMAT = "ws://%s/message?device=%s&app=%s&context=%s";
  private static final int PROTOCOL_VERSION = 2;
  private static final String TAG = "JSPackagerClient";
  private Map<String, RequestHandler> mRequestHandlers;
  private ReconnectingWebSocket mWebSocket;
  
  public JSPackagerClient(String paramString, PackagerConnectionSettings paramPackagerConnectionSettings, Map paramMap)
  {
    this(paramString, paramPackagerConnectionSettings, paramMap, null);
  }
  
  public JSPackagerClient(String paramString, PackagerConnectionSettings paramPackagerConnectionSettings, Map paramMap, ReconnectingWebSocket.ConnectionCallback paramConnectionCallback)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("ws").encodedAuthority(paramPackagerConnectionSettings.getDebugServerHost()).appendPath("message").appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter("app", paramPackagerConnectionSettings.getPackageName()).appendQueryParameter("clientid", paramString);
    mWebSocket = new ReconnectingWebSocket(localBuilder.build().toString(), this, paramConnectionCallback);
    mRequestHandlers = paramMap;
  }
  
  private void abortOnMessage(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      new ResponderImpl(paramObject).error(paramString);
    }
    paramObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Handling the message failed with reason: ");
    localStringBuilder.append(paramString);
    FLog.e(paramObject, localStringBuilder.toString());
  }
  
  public void close()
  {
    mWebSocket.closeQuietly();
  }
  
  public void init()
  {
    mWebSocket.connect();
  }
  
  public void onMessage(String paramString)
  {
    try
    {
      Object localObject2 = new JSONObject(paramString);
      int i = ((JSONObject)localObject2).optInt("version");
      paramString = ((JSONObject)localObject2).optString("method");
      Object localObject1 = ((JSONObject)localObject2).opt("id");
      localObject2 = ((JSONObject)localObject2).opt("params");
      if (i != 2)
      {
        paramString = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Message with incompatible or missing version of protocol received: ");
        ((StringBuilder)localObject1).append(i);
        FLog.e(paramString, ((StringBuilder)localObject1).toString());
        return;
      }
      if (paramString == null)
      {
        abortOnMessage(localObject1, "No method provided");
        return;
      }
      Object localObject3 = mRequestHandlers;
      localObject3 = ((Map)localObject3).get(paramString);
      localObject3 = (RequestHandler)localObject3;
      if (localObject3 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("No request handler for method: ");
        ((StringBuilder)localObject2).append(paramString);
        abortOnMessage(localObject1, ((StringBuilder)localObject2).toString());
        return;
      }
      if (localObject1 == null)
      {
        ((RequestHandler)localObject3).onNotification(localObject2);
        return;
      }
      ((RequestHandler)localObject3).onRequest(localObject2, new ResponderImpl(localObject1));
      return;
    }
    catch (Exception paramString)
    {
      FLog.e(TAG, "Handling the message failed", paramString);
    }
  }
  
  public void onMessage(ByteString paramByteString)
  {
    FLog.warn(TAG, "Websocket received message with payload of unexpected type binary");
  }
  
  private class ResponderImpl
    implements Responder
  {
    private Object val$data;
    
    public ResponderImpl(Object paramObject)
    {
      val$data = paramObject;
    }
    
    public void error(Object paramObject)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("version", 2);
        Object localObject = val$data;
        localJSONObject.put("id", localObject);
        localJSONObject.put("error", paramObject);
        paramObject = JSPackagerClient.this;
        mWebSocket.sendMessage(localJSONObject.toString());
        return;
      }
      catch (Exception paramObject)
      {
        FLog.e(JSPackagerClient.TAG, "Responding with error failed", paramObject);
      }
    }
    
    public void respond(Object paramObject)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("version", 2);
        Object localObject = val$data;
        localJSONObject.put("id", localObject);
        localJSONObject.put("result", paramObject);
        paramObject = JSPackagerClient.this;
        mWebSocket.sendMessage(localJSONObject.toString());
        return;
      }
      catch (Exception paramObject)
      {
        FLog.e(JSPackagerClient.TAG, "Responding failed", paramObject);
      }
    }
  }
}
