package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface ReadableMapKeySetIterator
{
  public abstract boolean hasNextKey();
  
  public abstract String nextKey();
}
