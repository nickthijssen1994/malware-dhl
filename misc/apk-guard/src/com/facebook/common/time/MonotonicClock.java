package com.facebook.common.time;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface MonotonicClock
{
  public abstract long now();
}
