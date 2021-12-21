package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ForwardingImageOriginListener
  implements ImageOriginListener
{
  private static final String PAGE_KEY = "ForwardingImageOriginListener";
  private final List<ImageOriginListener> mImageOriginListeners;
  
  public ForwardingImageOriginListener(Set paramSet)
  {
    mImageOriginListeners = new ArrayList(paramSet);
  }
  
  public ForwardingImageOriginListener(ImageOriginListener... paramVarArgs)
  {
    mImageOriginListeners = new ArrayList(paramVarArgs.length);
    Collections.addAll(mImageOriginListeners, paramVarArgs);
  }
  
  public void addImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      mImageOriginListeners.add(paramImageOriginListener);
      return;
    }
    catch (Throwable paramImageOriginListener)
    {
      throw paramImageOriginListener;
    }
  }
  
  public void onImageLoaded(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    try
    {
      int j = mImageOriginListeners.size();
      int i = 0;
      while (i < j)
      {
        ImageOriginListener localImageOriginListener = (ImageOriginListener)mImageOriginListeners.get(i);
        if (localImageOriginListener != null) {
          try
          {
            localImageOriginListener.onImageLoaded(paramString1, paramInt, paramBoolean, paramString2);
          }
          catch (Exception localException)
          {
            FLog.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", localException);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void removeImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      mImageOriginListeners.remove(paramImageOriginListener);
      return;
    }
    catch (Throwable paramImageOriginListener)
    {
      throw paramImageOriginListener;
    }
  }
}
