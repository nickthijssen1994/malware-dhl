package com.facebook.imagepipeline.image;

public class ImmutableQualityInfo
  implements QualityInfo
{
  public static final QualityInfo FULL_QUALITY = refresh(Integer.MAX_VALUE, true, true);
  boolean mIsOfFullQuality;
  boolean mIsOfGoodEnoughQuality;
  int mQuality;
  
  private ImmutableQualityInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    mQuality = paramInt;
    mIsOfGoodEnoughQuality = paramBoolean1;
    mIsOfFullQuality = paramBoolean2;
  }
  
  public static QualityInfo refresh(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new ImmutableQualityInfo(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ImmutableQualityInfo)) {
      return false;
    }
    paramObject = (ImmutableQualityInfo)paramObject;
    return (mQuality == mQuality) && (mIsOfGoodEnoughQuality == mIsOfGoodEnoughQuality) && (mIsOfFullQuality == mIsOfFullQuality);
  }
  
  public int getQuality()
  {
    return mQuality;
  }
  
  public int hashCode()
  {
    int k = mQuality;
    boolean bool = mIsOfGoodEnoughQuality;
    int j = 0;
    int i;
    if (bool) {
      i = 4194304;
    } else {
      i = 0;
    }
    if (mIsOfFullQuality) {
      j = 8388608;
    }
    return k ^ i ^ j;
  }
  
  public boolean isOfFullQuality()
  {
    return mIsOfFullQuality;
  }
  
  public boolean isOfGoodEnoughQuality()
  {
    return mIsOfGoodEnoughQuality;
  }
}
