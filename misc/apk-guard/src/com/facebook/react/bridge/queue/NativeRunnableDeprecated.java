package com.facebook.react.bridge.queue;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.Countable;

@DoNotStrip
public class NativeRunnableDeprecated
  extends Countable
  implements Runnable
{
  private NativeRunnableDeprecated() {}
  
  public native void run();
}
