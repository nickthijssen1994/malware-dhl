package com.facebook.react.module.model;

public class ReactModuleInfo
{
  private final boolean mCanOverrideExistingModule;
  private String mClassName;
  private final boolean mHasConstants;
  private final boolean mIsCxxModule;
  private final boolean mIsTurboModule;
  private final String mName;
  private final boolean mNeedsEagerInit;
  
  public ReactModuleInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    mName = paramString1;
    mClassName = paramString2;
    mCanOverrideExistingModule = paramBoolean1;
    mNeedsEagerInit = paramBoolean2;
    mHasConstants = paramBoolean3;
    mIsCxxModule = paramBoolean4;
    mIsTurboModule = paramBoolean5;
  }
  
  public boolean canOverrideExistingModule()
  {
    return mCanOverrideExistingModule;
  }
  
  public String className()
  {
    return mClassName;
  }
  
  public boolean hasConstants()
  {
    return mHasConstants;
  }
  
  public boolean isCxxModule()
  {
    return mIsCxxModule;
  }
  
  public boolean isTurboModule()
  {
    return mIsTurboModule;
  }
  
  public String name()
  {
    return mName;
  }
  
  public boolean needsEagerInit()
  {
    return mNeedsEagerInit;
  }
}
