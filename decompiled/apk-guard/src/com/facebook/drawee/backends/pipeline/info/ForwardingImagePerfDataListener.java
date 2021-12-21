package com.facebook.drawee.backends.pipeline.info;

import java.util.Collection;
import java.util.Iterator;

public class ForwardingImagePerfDataListener
  implements ImagePerfDataListener
{
  private final Collection<ImagePerfDataListener> mListeners;
  
  public ForwardingImagePerfDataListener(Collection paramCollection)
  {
    mListeners = paramCollection;
  }
  
  public void onImageLoadStatusUpdated(ImagePerfData paramImagePerfData, int paramInt)
  {
    Iterator localIterator = mListeners.iterator();
    while (localIterator.hasNext()) {
      ((ImagePerfDataListener)localIterator.next()).onImageLoadStatusUpdated(paramImagePerfData, paramInt);
    }
  }
  
  public void onImageVisibilityUpdated(ImagePerfData paramImagePerfData, int paramInt)
  {
    Iterator localIterator = mListeners.iterator();
    while (localIterator.hasNext()) {
      ((ImagePerfDataListener)localIterator.next()).onImageVisibilityUpdated(paramImagePerfData, paramInt);
    }
  }
}
