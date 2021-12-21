package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;

public class NoOpCloseableReferenceLeakTracker
  implements CloseableReferenceLeakTracker
{
  public NoOpCloseableReferenceLeakTracker() {}
  
  public boolean isSet()
  {
    return false;
  }
  
  public void setListener(CloseableReferenceLeakTracker.Listener paramListener) {}
  
  public void trackCloseableReferenceLeak(SharedReference paramSharedReference, Throwable paramThrowable) {}
}
