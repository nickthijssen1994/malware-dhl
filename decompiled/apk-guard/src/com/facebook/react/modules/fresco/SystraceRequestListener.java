package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.util.Pair;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.Systrace.EventScope;
import java.util.HashMap;
import java.util.Map;

public class SystraceRequestListener
  extends BaseRequestListener
{
  int mCurrentID = 0;
  Map<String, Pair<Integer, String>> mProducerID = new HashMap();
  Map<String, Pair<Integer, String>> mRequestsID = new HashMap();
  
  public SystraceRequestListener() {}
  
  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_EVENT_");
    localStringBuilder.append(paramString1.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3.replace(':', '_'));
    Systrace.traceInstant(0L, localStringBuilder.toString(), Systrace.EventScope.THREAD);
  }
  
  public void onProducerFinishWithCancellation(String paramString1, String paramString2, Map paramMap)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    if (mProducerID.containsKey(paramString1))
    {
      paramString2 = (Pair)mProducerID.get(paramString1);
      Systrace.endAsyncSection(0L, (String)second, ((Integer)first).intValue());
      mProducerID.remove(paramString1);
    }
  }
  
  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map paramMap)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    if (mProducerID.containsKey(paramString1))
    {
      paramString2 = (Pair)mProducerID.get(paramString1);
      Systrace.endAsyncSection(0L, (String)second, ((Integer)first).intValue());
      mProducerID.remove(paramString1);
    }
  }
  
  public void onProducerFinishWithSuccess(String paramString1, String paramString2, Map paramMap)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    if (mProducerID.containsKey(paramString1))
    {
      paramString2 = (Pair)mProducerID.get(paramString1);
      Systrace.endAsyncSection(0L, (String)second, ((Integer)first).intValue());
      mProducerID.remove(paramString1);
    }
  }
  
  public void onProducerStart(String paramString1, String paramString2)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    paramString2 = Pair.create(Integer.valueOf(mCurrentID), localStringBuilder.toString());
    Systrace.beginAsyncSection(0L, (String)second, mCurrentID);
    mProducerID.put(paramString1, paramString2);
    mCurrentID += 1;
  }
  
  public void onRequestCancellation(String paramString)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    if (mRequestsID.containsKey(paramString))
    {
      Pair localPair = (Pair)mRequestsID.get(paramString);
      Systrace.endAsyncSection(0L, (String)second, ((Integer)first).intValue());
      mRequestsID.remove(paramString);
    }
  }
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    if (mRequestsID.containsKey(paramString))
    {
      paramImageRequest = (Pair)mRequestsID.get(paramString);
      Systrace.endAsyncSection(0L, (String)second, ((Integer)first).intValue());
      mRequestsID.remove(paramString);
    }
  }
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("FRESCO_REQUEST_");
    paramObject.append(paramImageRequest.getSourceUri().toString().replace(':', '_'));
    paramImageRequest = Pair.create(Integer.valueOf(mCurrentID), paramObject.toString());
    Systrace.beginAsyncSection(0L, (String)second, mCurrentID);
    mRequestsID.put(paramString, paramImageRequest);
    mCurrentID += 1;
  }
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    if (mRequestsID.containsKey(paramString))
    {
      paramImageRequest = (Pair)mRequestsID.get(paramString);
      Systrace.endAsyncSection(0L, (String)second, ((Integer)first).intValue());
      mRequestsID.remove(paramString);
    }
  }
  
  public boolean requiresExtraMap(String paramString)
  {
    return false;
  }
}
