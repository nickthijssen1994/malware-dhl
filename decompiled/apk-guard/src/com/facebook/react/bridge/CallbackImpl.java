package com.facebook.react.bridge;

public final class CallbackImpl
  implements Callback
{
  private final int mCallbackId;
  private boolean mInvoked;
  private final JSInstance mJSInstance;
  
  public CallbackImpl(JSInstance paramJSInstance, int paramInt)
  {
    mJSInstance = paramJSInstance;
    mCallbackId = paramInt;
    mInvoked = false;
  }
  
  public void invoke(Object... paramVarArgs)
  {
    if (!mInvoked)
    {
      mJSInstance.invokeCallback(mCallbackId, Arguments.fromJavaArgs(paramVarArgs));
      mInvoked = true;
      return;
    }
    throw new RuntimeException("Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
  }
}
