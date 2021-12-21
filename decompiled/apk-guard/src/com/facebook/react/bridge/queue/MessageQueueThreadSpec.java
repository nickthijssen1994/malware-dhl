package com.facebook.react.bridge.queue;

public class MessageQueueThreadSpec
{
  public static final long DEFAULT_STACK_SIZE_BYTES = 0L;
  private static final MessageQueueThreadSpec MAIN_UI_SPEC = new MessageQueueThreadSpec(ThreadType.MAIN_UI, "main_ui");
  private final String mName;
  private final long mStackSize;
  private final ThreadType mThreadType;
  
  private MessageQueueThreadSpec(ThreadType paramThreadType, String paramString)
  {
    this(paramThreadType, paramString, 0L);
  }
  
  private MessageQueueThreadSpec(ThreadType paramThreadType, String paramString, long paramLong)
  {
    mThreadType = paramThreadType;
    mName = paramString;
    mStackSize = paramLong;
  }
  
  public static MessageQueueThreadSpec mainThreadSpec()
  {
    return MAIN_UI_SPEC;
  }
  
  public static MessageQueueThreadSpec newBackgroundThreadSpec(String paramString)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString);
  }
  
  public static MessageQueueThreadSpec newBackgroundThreadSpec(String paramString, long paramLong)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString, paramLong);
  }
  
  public static MessageQueueThreadSpec newUIBackgroundTreadSpec(String paramString)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString);
  }
  
  public String getName()
  {
    return mName;
  }
  
  public long getStackSize()
  {
    return mStackSize;
  }
  
  public ThreadType getThreadType()
  {
    return mThreadType;
  }
  
  protected static enum ThreadType
  {
    MAIN_UI,  NEW_BACKGROUND;
  }
}
