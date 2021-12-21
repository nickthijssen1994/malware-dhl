package com.facebook.common.time;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface Clock
{
  public static final long MAX_TIME = Long.MAX_VALUE;
  
  public abstract long now();
}
