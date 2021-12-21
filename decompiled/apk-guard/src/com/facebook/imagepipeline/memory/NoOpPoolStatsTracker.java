package com.facebook.imagepipeline.memory;

public class NoOpPoolStatsTracker
  implements PoolStatsTracker
{
  private static NoOpPoolStatsTracker sInstance;
  
  private NoOpPoolStatsTracker() {}
  
  public static NoOpPoolStatsTracker getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpPoolStatsTracker();
      }
      NoOpPoolStatsTracker localNoOpPoolStatsTracker = sInstance;
      return localNoOpPoolStatsTracker;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void onAlloc(int paramInt) {}
  
  public void onFree(int paramInt) {}
  
  public void onHardCapReached() {}
  
  public void onSoftCapReached() {}
  
  public void onValueRelease(int paramInt) {}
  
  public void onValueReuse(int paramInt) {}
  
  public void setBasePool(BasePool paramBasePool) {}
}
