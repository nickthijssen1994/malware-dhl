package com.facebook.imagepipeline.memory;

import java.util.HashSet;
import java.util.Set;

public abstract class LruBucketsPoolBackend<T>
  implements PoolBackend<T>
{
  private final Set<T> mCurrentItems = new HashSet();
  private final BucketMap<T> mMap = new BucketMap();
  
  public LruBucketsPoolBackend() {}
  
  private Object maybeRemoveFromCurrentItems(Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        mCurrentItems.remove(paramObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        throw paramObject;
      }
    }
    return paramObject;
  }
  
  public Object get(int paramInt)
  {
    return maybeRemoveFromCurrentItems(mMap.acquire(paramInt));
  }
  
  public void put(Object paramObject)
  {
    try
    {
      boolean bool = mCurrentItems.add(paramObject);
      if (bool)
      {
        mMap.release(getSize(paramObject), paramObject);
        return;
      }
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public Object putIfAbsent()
  {
    return maybeRemoveFromCurrentItems(mMap.removeFromEnd());
  }
  
  int valueCount()
  {
    return mMap.valueCount();
  }
}
