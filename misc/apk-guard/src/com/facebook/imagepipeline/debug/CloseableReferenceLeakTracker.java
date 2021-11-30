package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;

public abstract interface CloseableReferenceLeakTracker
{
  public abstract boolean isSet();
  
  public abstract void setListener(Listener paramListener);
  
  public abstract void trackCloseableReferenceLeak(SharedReference paramSharedReference, Throwable paramThrowable);
  
  public static abstract interface Listener
  {
    public abstract void onCloseableReferenceLeak(SharedReference paramSharedReference, Throwable paramThrowable);
  }
}
