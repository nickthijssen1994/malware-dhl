package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.upgrade.HybridData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DoNotStrip
public class Inspector
{
  private final HybridData mHybridData;
  
  static {}
  
  private Inspector(HybridData paramHybridData)
  {
    mHybridData = paramHybridData;
  }
  
  public static LocalConnection connect(int paramInt, RemoteConnection paramRemoteConnection)
  {
    try
    {
      paramRemoteConnection = instance().connectNative(paramInt, paramRemoteConnection);
      return paramRemoteConnection;
    }
    catch (UnsatisfiedLinkError paramRemoteConnection)
    {
      FLog.e("ReactNative", "Inspector doesn't work in open source yet", paramRemoteConnection);
      throw new RuntimeException(paramRemoteConnection);
    }
  }
  
  private native LocalConnection connectNative(int paramInt, RemoteConnection paramRemoteConnection);
  
  public static List getPages()
  {
    try
    {
      List localList = Arrays.asList(instance().getPagesNative());
      return localList;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      FLog.e("ReactNative", "Inspector doesn't work in open source yet", localUnsatisfiedLinkError);
    }
    return Collections.emptyList();
  }
  
  private native Page[] getPagesNative();
  
  private static native Inspector instance();
  
  @DoNotStrip
  public static class LocalConnection
  {
    private final HybridData mHybridData;
    
    private LocalConnection(HybridData paramHybridData)
    {
      mHybridData = paramHybridData;
    }
    
    public native void disconnect();
    
    public native void sendMessage(String paramString);
  }
  
  @DoNotStrip
  public static class Page
  {
    private final int mId;
    private final String mLicense;
    private final String mTitle;
    
    private Page(int paramInt, String paramString1, String paramString2)
    {
      mId = paramInt;
      mTitle = paramString1;
      mLicense = paramString2;
    }
    
    public int getId()
    {
      return mId;
    }
    
    public String getTitle()
    {
      return mTitle;
    }
    
    public String getVM()
    {
      return mLicense;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Page{mId=");
      localStringBuilder.append(mId);
      localStringBuilder.append(", mTitle='");
      localStringBuilder.append(mTitle);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  @DoNotStrip
  public static abstract interface RemoteConnection
  {
    public abstract void onDisconnect();
    
    public abstract void onMessage(String paramString);
  }
}
