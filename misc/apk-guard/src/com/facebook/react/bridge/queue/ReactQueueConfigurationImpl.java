package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.react.common.MapBuilder;
import java.util.Map;

public class ReactQueueConfigurationImpl
  implements ReactQueueConfiguration
{
  private final MessageQueueThreadImpl mJSQueueThread;
  private final MessageQueueThreadImpl mNativeModulesQueueThread;
  private final MessageQueueThreadImpl mUIQueueThread;
  
  private ReactQueueConfigurationImpl(MessageQueueThreadImpl paramMessageQueueThreadImpl1, MessageQueueThreadImpl paramMessageQueueThreadImpl2, MessageQueueThreadImpl paramMessageQueueThreadImpl3)
  {
    mUIQueueThread = paramMessageQueueThreadImpl1;
    mNativeModulesQueueThread = paramMessageQueueThreadImpl2;
    mJSQueueThread = paramMessageQueueThreadImpl3;
  }
  
  public static ReactQueueConfigurationImpl create(ReactQueueConfigurationSpec paramReactQueueConfigurationSpec, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    Object localObject3 = MapBuilder.newHashMap();
    Object localObject1 = MessageQueueThreadSpec.mainThreadSpec();
    MessageQueueThreadImpl localMessageQueueThreadImpl = MessageQueueThreadImpl.create((MessageQueueThreadSpec)localObject1, paramQueueThreadExceptionHandler);
    ((Map)localObject3).put(localObject1, localMessageQueueThreadImpl);
    Object localObject2 = (MessageQueueThreadImpl)((Map)localObject3).get(paramReactQueueConfigurationSpec.getJSQueueThreadSpec());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MessageQueueThreadImpl.create(paramReactQueueConfigurationSpec.getJSQueueThreadSpec(), paramQueueThreadExceptionHandler);
    }
    localObject3 = (MessageQueueThreadImpl)((Map)localObject3).get(paramReactQueueConfigurationSpec.getNativeModulesQueueThreadSpec());
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = MessageQueueThreadImpl.create(paramReactQueueConfigurationSpec.getNativeModulesQueueThreadSpec(), paramQueueThreadExceptionHandler);
    }
    return new ReactQueueConfigurationImpl(localMessageQueueThreadImpl, (MessageQueueThreadImpl)localObject2, (MessageQueueThreadImpl)localObject1);
  }
  
  public void destroy()
  {
    if (mNativeModulesQueueThread.getLooper() != Looper.getMainLooper()) {
      mNativeModulesQueueThread.quitSynchronous();
    }
    if (mJSQueueThread.getLooper() != Looper.getMainLooper()) {
      mJSQueueThread.quitSynchronous();
    }
  }
  
  public MessageQueueThread getJSQueueThread()
  {
    return mJSQueueThread;
  }
  
  public MessageQueueThread getNativeModulesQueueThread()
  {
    return mNativeModulesQueueThread;
  }
  
  public MessageQueueThread getUIQueueThread()
  {
    return mUIQueueThread;
  }
}
