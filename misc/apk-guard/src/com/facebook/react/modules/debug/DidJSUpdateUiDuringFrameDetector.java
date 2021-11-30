package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;

public class DidJSUpdateUiDuringFrameDetector
  implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener
{
  private final LongArray mTransitionToBusyEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mTransitionToIdleEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateEnqueuedEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateFinishedEvents = LongArray.createWithInitialCapacity(20);
  private volatile boolean mWasIdleAtEndOfLastFrame = true;
  
  public DidJSUpdateUiDuringFrameDetector() {}
  
  private static void cleanUp(LongArray paramLongArray, long paramLong)
  {
    int n = paramLongArray.size();
    int m = 0;
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (paramLongArray.set(j) < paramLong) {
        k = i + 1;
      }
      j += 1;
    }
    if (i > 0)
    {
      j = m;
      while (j < n - i)
      {
        paramLongArray.add(j, paramLongArray.set(j + i));
        j += 1;
      }
      paramLongArray.dropTail(i);
    }
  }
  
  private boolean didEndFrameIdle(long paramLong1, long paramLong2)
  {
    long l = getLastEventBetweenTimestamps(mTransitionToIdleEvents, paramLong1, paramLong2);
    paramLong1 = getLastEventBetweenTimestamps(mTransitionToBusyEvents, paramLong1, paramLong2);
    if ((l == -1L) && (paramLong1 == -1L)) {
      return mWasIdleAtEndOfLastFrame;
    }
    return l > paramLong1;
  }
  
  private static long getLastEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    long l1 = -1L;
    int i = 0;
    while (i < paramLongArray.size())
    {
      long l3 = paramLongArray.set(i);
      long l2;
      if ((l3 >= paramLong1) && (l3 < paramLong2))
      {
        l2 = l3;
      }
      else
      {
        l2 = l1;
        if (l3 >= paramLong2) {
          return l1;
        }
      }
      i += 1;
      l1 = l2;
    }
    return l1;
  }
  
  private static boolean hasEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    int i = 0;
    while (i < paramLongArray.size())
    {
      long l = paramLongArray.set(i);
      if ((l >= paramLong1) && (l < paramLong2)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean getDidJSHitFrameAndCleanup(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        boolean bool3 = hasEventBetweenTimestamps(mViewHierarchyUpdateFinishedEvents, paramLong1, paramLong2);
        boolean bool2 = didEndFrameIdle(paramLong1, paramLong2);
        bool1 = true;
        if (!bool3) {
          if ((!bool2) || (hasEventBetweenTimestamps(mViewHierarchyUpdateEnqueuedEvents, paramLong1, paramLong2))) {
            break label102;
          }
        }
        cleanUp(mTransitionToIdleEvents, paramLong2);
        cleanUp(mTransitionToBusyEvents, paramLong2);
        cleanUp(mViewHierarchyUpdateEnqueuedEvents, paramLong2);
        cleanUp(mViewHierarchyUpdateFinishedEvents, paramLong2);
        mWasIdleAtEndOfLastFrame = bool2;
        return bool1;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      label102:
      boolean bool1 = false;
    }
  }
  
  public void onBridgeDestroyed() {}
  
  public void onTransitionToBridgeBusy()
  {
    try
    {
      mTransitionToBusyEvents.ensureCapacity(System.nanoTime());
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void onTransitionToBridgeIdle()
  {
    try
    {
      mTransitionToIdleEvents.ensureCapacity(System.nanoTime());
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void onViewHierarchyUpdateEnqueued()
  {
    try
    {
      mViewHierarchyUpdateEnqueuedEvents.ensureCapacity(System.nanoTime());
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void onViewHierarchyUpdateFinished()
  {
    try
    {
      mViewHierarchyUpdateFinishedEvents.ensureCapacity(System.nanoTime());
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
