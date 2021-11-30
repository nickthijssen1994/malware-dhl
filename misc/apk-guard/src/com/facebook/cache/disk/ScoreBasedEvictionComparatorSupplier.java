package com.facebook.cache.disk;

public class ScoreBasedEvictionComparatorSupplier
  implements EntryEvictionComparatorSupplier
{
  private final float mAgeWeight;
  private final float mSizeWeight;
  
  public ScoreBasedEvictionComparatorSupplier(float paramFloat1, float paramFloat2)
  {
    mAgeWeight = paramFloat1;
    mSizeWeight = paramFloat2;
  }
  
  float calculateScore(DiskStorage.Entry paramEntry, long paramLong)
  {
    long l1 = paramEntry.getTimestamp();
    long l2 = paramEntry.getSize();
    return mAgeWeight * (float)(paramLong - l1) + mSizeWeight * (float)l2;
  }
  
  public EntryEvictionComparator getLastSms()
  {
    new EntryEvictionComparator()
    {
      long start = System.currentTimeMillis();
      
      public int compare(DiskStorage.Entry paramAnonymousEntry1, DiskStorage.Entry paramAnonymousEntry2)
      {
        float f1 = calculateScore(paramAnonymousEntry1, start);
        float f2 = calculateScore(paramAnonymousEntry2, start);
        if (f1 < f2) {
          return 1;
        }
        if (f2 == f1) {
          return 0;
        }
        return -1;
      }
    };
  }
}
