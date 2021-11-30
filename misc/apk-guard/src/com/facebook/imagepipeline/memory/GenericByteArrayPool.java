package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class GenericByteArrayPool
  extends BasePool<byte[]>
  implements ByteArrayPool
{
  private final int[] mBucketSizes;
  
  public GenericByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    paramMemoryTrimmableRegistry = bucketSizes;
    mBucketSizes = new int[paramMemoryTrimmableRegistry.size()];
    int i = 0;
    while (i < paramMemoryTrimmableRegistry.size())
    {
      mBucketSizes[i] = paramMemoryTrimmableRegistry.keyAt(i);
      i += 1;
    }
    initialize();
  }
  
  protected byte[] alloc(int paramInt)
  {
    return new byte[paramInt];
  }
  
  protected void free(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
  }
  
  protected int getBucketedSize(int paramInt)
  {
    if (paramInt > 0)
    {
      int[] arrayOfInt = mBucketSizes;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        if (k >= paramInt) {
          return k;
        }
        i += 1;
      }
      return paramInt;
    }
    throw new BasePool.InvalidSizeException(Integer.valueOf(paramInt));
  }
  
  protected int getBucketedSizeForValue(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    return paramArrayOfByte.length;
  }
  
  public int getMinBufferSize()
  {
    return mBucketSizes[0];
  }
  
  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }
}
