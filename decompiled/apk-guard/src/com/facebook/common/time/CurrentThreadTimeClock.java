package com.facebook.common.time;

import android.os.SystemClock;

public class CurrentThreadTimeClock
  implements Clock
{
  public CurrentThreadTimeClock() {}
  
  public long now()
  {
    return SystemClock.currentThreadTimeMillis();
  }
}
