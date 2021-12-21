package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForwardingRequestListener
  implements RequestListener
{
  private static final String PAGE_KEY = "ForwardingRequestListener";
  private final List<RequestListener> mRequestListeners;
  
  public ForwardingRequestListener(Set paramSet)
  {
    mRequestListeners = new ArrayList(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      RequestListener localRequestListener = (RequestListener)paramSet.next();
      if (localRequestListener != null) {
        mRequestListeners.add(localRequestListener);
      }
    }
  }
  
  public ForwardingRequestListener(RequestListener... paramVarArgs)
  {
    mRequestListeners = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = paramVarArgs[i];
      if (localRequestListener != null) {
        mRequestListeners.add(localRequestListener);
      }
      i += 1;
    }
  }
  
  private void onException(String paramString, Throwable paramThrowable)
  {
    FLog.e("ForwardingRequestListener", paramString, paramThrowable);
  }
  
  public void addRequestListener(RequestListener paramRequestListener)
  {
    mRequestListeners.add(paramRequestListener);
  }
  
  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerEvent(paramString1, paramString2, paramString3);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onIntermediateChunkStart", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerFinishWithCancellation(String paramString1, String paramString2, Map paramMap)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerFinishWithCancellation(paramString1, paramString2, paramMap);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithCancellation", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map paramMap)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerFinishWithFailure(paramString1, paramString2, paramThrowable, paramMap);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithFailure", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerFinishWithSuccess(String paramString1, String paramString2, Map paramMap)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerFinishWithSuccess(paramString1, paramString2, paramMap);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithSuccess", localException);
      }
      i += 1;
    }
  }
  
  public void onProducerStart(String paramString1, String paramString2)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerStart(paramString1, paramString2);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerStart", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestCancellation(String paramString)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestCancellation(paramString);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestCancellation", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestFailure(paramImageRequest, paramString, paramThrowable, paramBoolean);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestFailure", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestStart(paramImageRequest, paramObject, paramString, paramBoolean);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestStart", localException);
      }
      i += 1;
    }
  }
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestSuccess(paramImageRequest, paramString, paramBoolean);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onRequestSuccess", localException);
      }
      i += 1;
    }
  }
  
  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      RequestListener localRequestListener = (RequestListener)mRequestListeners.get(i);
      try
      {
        localRequestListener.onUltimateProducerReached(paramString1, paramString2, paramBoolean);
      }
      catch (Exception localException)
      {
        onException("InternalListener exception in onProducerFinishWithSuccess", localException);
      }
      i += 1;
    }
  }
  
  public boolean requiresExtraMap(String paramString)
  {
    int j = mRequestListeners.size();
    int i = 0;
    while (i < j)
    {
      if (((RequestListener)mRequestListeners.get(i)).requiresExtraMap(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}
