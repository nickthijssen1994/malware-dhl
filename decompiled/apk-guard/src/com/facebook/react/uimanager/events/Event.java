package com.facebook.react.uimanager.events;

import com.facebook.react.common.SystemClock;

public abstract class Event<T extends Event>
{
  private static int sUniqueID;
  private boolean mInitialized;
  private long mTimestampMs;
  private int mUniqueID;
  private int mViewTag;
  
  protected Event()
  {
    int i = sUniqueID;
    sUniqueID = i + 1;
    mUniqueID = i;
  }
  
  protected Event(int paramInt)
  {
    int i = sUniqueID;
    sUniqueID = i + 1;
    mUniqueID = i;
    init(paramInt);
  }
  
  public boolean canCoalesce()
  {
    return true;
  }
  
  public Event coalesce(Event paramEvent)
  {
    if (getTimestampMs() >= paramEvent.getTimestampMs()) {
      return this;
    }
    return paramEvent;
  }
  
  public abstract void dispatch(RCTEventEmitter paramRCTEventEmitter);
  
  final void dispose()
  {
    mInitialized = false;
    onDispose();
  }
  
  public short getCoalescingKey()
  {
    return 0;
  }
  
  public abstract String getEventName();
  
  public final long getTimestampMs()
  {
    return mTimestampMs;
  }
  
  public int getUniqueID()
  {
    return mUniqueID;
  }
  
  public final int getViewTag()
  {
    return mViewTag;
  }
  
  protected void init(int paramInt)
  {
    mViewTag = paramInt;
    mTimestampMs = SystemClock.uptimeMillis();
    mInitialized = true;
  }
  
  boolean isInitialized()
  {
    return mInitialized;
  }
  
  public void onDispose() {}
}
