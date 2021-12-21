package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;

public class SimpleProgressiveJpegConfig
  implements ProgressiveJpegConfig
{
  private final DynamicValueConfig mDynamicValueConfig;
  
  public SimpleProgressiveJpegConfig()
  {
    this(new DefaultDynamicValueConfig(null));
  }
  
  public SimpleProgressiveJpegConfig(DynamicValueConfig paramDynamicValueConfig)
  {
    mDynamicValueConfig = ((DynamicValueConfig)Preconditions.checkNotNull(paramDynamicValueConfig));
  }
  
  public int getNextScanNumberToDecode(int paramInt)
  {
    List localList = mDynamicValueConfig.getScansToDecode();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        if (((Integer)localList.get(i)).intValue() > paramInt) {
          return ((Integer)localList.get(i)).intValue();
        }
        i += 1;
      }
      return Integer.MAX_VALUE;
    }
    return paramInt + 1;
  }
  
  public QualityInfo getQualityInfo(int paramInt)
  {
    boolean bool;
    if (paramInt >= mDynamicValueConfig.getGoodEnoughScanNumber()) {
      bool = true;
    } else {
      bool = false;
    }
    return ImmutableQualityInfo.refresh(paramInt, bool, false);
  }
  
  private static class DefaultDynamicValueConfig
    implements SimpleProgressiveJpegConfig.DynamicValueConfig
  {
    private DefaultDynamicValueConfig() {}
    
    public int getGoodEnoughScanNumber()
    {
      return 0;
    }
    
    public List getScansToDecode()
    {
      return Collections.EMPTY_LIST;
    }
  }
  
  public static abstract interface DynamicValueConfig
  {
    public abstract int getGoodEnoughScanNumber();
    
    public abstract List getScansToDecode();
  }
}
