package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.HybridData;

@DoNotStrip
public class CxxCallbackImpl
  implements Callback
{
  @DoNotStrip
  private final HybridData mHybridData;
  
  private CxxCallbackImpl(HybridData paramHybridData)
  {
    mHybridData = paramHybridData;
  }
  
  private native void nativeInvoke(NativeArray paramNativeArray);
  
  public void invoke(Object... paramVarArgs)
  {
    nativeInvoke(Arguments.fromJavaArgs(paramVarArgs));
  }
}
