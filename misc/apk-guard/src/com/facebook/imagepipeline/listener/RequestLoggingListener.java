package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class RequestLoggingListener
  implements RequestListener
{
  private static final String PAGE_KEY = "RequestLoggingListener";
  @GuardedBy("this")
  private final Map<Pair<String, String>, Long> mProducerStartTimeMap = new HashMap();
  @GuardedBy("this")
  private final Map<String, Long> mRequestStartTimeMap = new HashMap();
  
  public RequestLoggingListener() {}
  
  private static long getElapsedTime(Long paramLong, long paramLong1)
  {
    if (paramLong != null) {
      return paramLong1 - paramLong.longValue();
    }
    return -1L;
  }
  
  private static long getTime()
  {
    return SystemClock.uptimeMillis();
  }
  
  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)mProducerStartTimeMap.get(localObject);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", new Object[] { Long.valueOf(getTime()), paramString1, paramString2, paramString3, Long.valueOf(getElapsedTime((Long)localObject, l)) });
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void onProducerFinishWithCancellation(String paramString1, String paramString2, Map paramMap)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)mProducerStartTimeMap.remove(localObject);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", new Object[] { Long.valueOf(l), paramString1, paramString2, Long.valueOf(getElapsedTime((Long)localObject, l)), paramMap });
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map paramMap)
  {
    try
    {
      if (FLog.isLoggable(5))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)mProducerStartTimeMap.remove(localObject);
        long l = getTime();
        FLog.w("RequestLoggingListener", paramThrowable, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", new Object[] { Long.valueOf(l), paramString1, paramString2, Long.valueOf(getElapsedTime((Long)localObject, l)), paramMap, paramThrowable.toString() });
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void onProducerFinishWithSuccess(String paramString1, String paramString2, Map paramMap)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)mProducerStartTimeMap.remove(localObject);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", new Object[] { Long.valueOf(l), paramString1, paramString2, Long.valueOf(getElapsedTime((Long)localObject, l)), paramMap });
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void onProducerStart(String paramString1, String paramString2)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        long l = getTime();
        mProducerStartTimeMap.put(localPair, Long.valueOf(l));
        FLog.v("RequestLoggingListener", "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(l), paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void onRequestCancellation(String paramString)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Long localLong = (Long)mRequestStartTimeMap.remove(paramString);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(l), paramString, Long.valueOf(getElapsedTime(localLong, l)));
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(5))
      {
        paramImageRequest = (Long)mRequestStartTimeMap.remove(paramString);
        long l = getTime();
        FLog.w("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", new Object[] { Long.valueOf(l), paramString, Long.valueOf(getElapsedTime(paramImageRequest, l)), paramThrowable.toString() });
      }
      return;
    }
    catch (Throwable paramImageRequest)
    {
      throw paramImageRequest;
    }
  }
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        FLog.v("RequestLoggingListener", "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(getTime()), paramString, paramObject, Boolean.valueOf(paramBoolean));
        mRequestStartTimeMap.put(paramString, Long.valueOf(getTime()));
      }
      return;
    }
    catch (Throwable paramImageRequest)
    {
      throw paramImageRequest;
    }
  }
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        paramImageRequest = (Long)mRequestStartTimeMap.remove(paramString);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(l), paramString, Long.valueOf(getElapsedTime(paramImageRequest, l)));
      }
      return;
    }
    catch (Throwable paramImageRequest)
    {
      throw paramImageRequest;
    }
  }
  
  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)mProducerStartTimeMap.remove(localObject);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", new Object[] { Long.valueOf(l), paramString1, paramString2, Long.valueOf(getElapsedTime((Long)localObject, l)), Boolean.valueOf(paramBoolean) });
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public boolean requiresExtraMap(String paramString)
  {
    return FLog.isLoggable(2);
  }
}
