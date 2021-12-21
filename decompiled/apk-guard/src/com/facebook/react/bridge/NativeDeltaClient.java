package com.facebook.react.bridge;

import com.facebook.upgrade.HybridData;
import java.nio.channels.ReadableByteChannel;

public class NativeDeltaClient
{
  private final HybridData mHybridData = initHybrid();
  
  static {}
  
  public NativeDeltaClient() {}
  
  private static native HybridData initHybrid();
  
  public native void processDelta(ReadableByteChannel paramReadableByteChannel);
  
  public native void reset();
}
