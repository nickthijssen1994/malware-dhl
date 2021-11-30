package com.facebook.react.common;

import androidx.core.util.Pools.Pool;

public class ClearableSynchronizedPool<T>
  implements Pools.Pool<T>
{
  private final Object[] mPool;
  private int mSize = 0;
  
  public ClearableSynchronizedPool(int paramInt)
  {
    mPool = new Object[paramInt];
  }
  
  public Object acquire()
  {
    try
    {
      int i = mSize;
      if (i == 0) {
        return null;
      }
      mSize -= 1;
      i = mSize;
      Object localObject = mPool[i];
      mPool[i] = null;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void clear()
  {
    int i = 0;
    try
    {
      while (i < mSize)
      {
        mPool[i] = null;
        i += 1;
      }
      mSize = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean release(Object paramObject)
  {
    try
    {
      int i = mSize;
      int j = mPool.length;
      if (i == j) {
        return false;
      }
      mPool[mSize] = paramObject;
      mSize += 1;
      return true;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
}
