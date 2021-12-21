package com.facebook.imagepipeline.memory;

public class BitmapCounterConfig
{
  public static final int DEFAULT_MAX_BITMAP_COUNT = 384;
  private int mMaxBitmapCount = 384;
  
  public BitmapCounterConfig(Builder paramBuilder)
  {
    mMaxBitmapCount = paramBuilder.getMaxBitmapCount();
  }
  
  public static Builder newBuilder()
  {
    return new Builder(null);
  }
  
  public int getMaxBitmapCount()
  {
    return mMaxBitmapCount;
  }
  
  public void setMaxBitmapCount(int paramInt)
  {
    mMaxBitmapCount = paramInt;
  }
  
  public static class Builder
  {
    private int mMaxBitmapCount = 384;
    
    private Builder() {}
    
    public BitmapCounterConfig build()
    {
      return new BitmapCounterConfig(this);
    }
    
    public int getMaxBitmapCount()
    {
      return mMaxBitmapCount;
    }
    
    public Builder setMaxBitmapCount(int paramInt)
    {
      mMaxBitmapCount = paramInt;
      return this;
    }
  }
}
