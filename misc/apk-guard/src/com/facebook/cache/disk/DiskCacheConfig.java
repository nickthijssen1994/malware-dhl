package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;
import javax.annotation.Nullable;

public class DiskCacheConfig
{
  private final String mBaseDirectoryName;
  private final Supplier<File> mBaseDirectoryPathSupplier;
  private final CacheErrorLogger mCacheErrorLogger;
  private final CacheEventListener mCacheEventListener;
  private final Context mContext;
  private final long mDefaultSizeLimit;
  private final DiskTrimmableRegistry mDiskTrimmableRegistry;
  private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
  private final boolean mIndexPopulateAtStartupEnabled;
  private final long mLowDiskSpaceSizeLimit;
  private final long mMinimumSizeLimit;
  private final int mVersion;
  
  private DiskCacheConfig(Builder paramBuilder)
  {
    mVersion = mVersion;
    mBaseDirectoryName = ((String)Preconditions.checkNotNull(mBaseDirectoryName));
    mBaseDirectoryPathSupplier = ((Supplier)Preconditions.checkNotNull(mBaseDirectoryPathSupplier));
    mDefaultSizeLimit = mMaxCacheSize;
    mLowDiskSpaceSizeLimit = mMaxCacheSizeOnLowDiskSpace;
    mMinimumSizeLimit = mMaxCacheSizeOnVeryLowDiskSpace;
    mEntryEvictionComparatorSupplier = ((EntryEvictionComparatorSupplier)Preconditions.checkNotNull(mEntryEvictionComparatorSupplier));
    Object localObject;
    if (mCacheErrorLogger == null) {
      localObject = NoOpCacheErrorLogger.getInstance();
    } else {
      localObject = mCacheErrorLogger;
    }
    mCacheErrorLogger = ((CacheErrorLogger)localObject);
    if (mCacheEventListener == null) {
      localObject = NoOpCacheEventListener.getInstance();
    } else {
      localObject = mCacheEventListener;
    }
    mCacheEventListener = ((CacheEventListener)localObject);
    if (mDiskTrimmableRegistry == null) {
      localObject = NoOpDiskTrimmableRegistry.getInstance();
    } else {
      localObject = mDiskTrimmableRegistry;
    }
    mDiskTrimmableRegistry = ((DiskTrimmableRegistry)localObject);
    mContext = mContext;
    mIndexPopulateAtStartupEnabled = mIndexPopulateAtStartupEnabled;
  }
  
  public static Builder newBuilder(Context paramContext)
  {
    return new Builder(paramContext, null);
  }
  
  public String getBaseDirectoryName()
  {
    return mBaseDirectoryName;
  }
  
  public Supplier getBaseDirectoryPathSupplier()
  {
    return mBaseDirectoryPathSupplier;
  }
  
  public CacheErrorLogger getCacheErrorLogger()
  {
    return mCacheErrorLogger;
  }
  
  public CacheEventListener getCacheEventListener()
  {
    return mCacheEventListener;
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public long getDefaultSizeLimit()
  {
    return mDefaultSizeLimit;
  }
  
  public DiskTrimmableRegistry getDiskTrimmableRegistry()
  {
    return mDiskTrimmableRegistry;
  }
  
  public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier()
  {
    return mEntryEvictionComparatorSupplier;
  }
  
  public boolean getIndexPopulateAtStartupEnabled()
  {
    return mIndexPopulateAtStartupEnabled;
  }
  
  public long getLowDiskSpaceSizeLimit()
  {
    return mLowDiskSpaceSizeLimit;
  }
  
  public long getMinimumSizeLimit()
  {
    return mMinimumSizeLimit;
  }
  
  public int getVersion()
  {
    return mVersion;
  }
  
  public static class Builder
  {
    private String mBaseDirectoryName = "image_cache";
    private Supplier<File> mBaseDirectoryPathSupplier;
    private CacheErrorLogger mCacheErrorLogger;
    private CacheEventListener mCacheEventListener;
    @Nullable
    private final Context mContext;
    private DiskTrimmableRegistry mDiskTrimmableRegistry;
    private EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
    private boolean mIndexPopulateAtStartupEnabled;
    private long mMaxCacheSize = 41943040L;
    private long mMaxCacheSizeOnLowDiskSpace = 10485760L;
    private long mMaxCacheSizeOnVeryLowDiskSpace = 2097152L;
    private int mVersion = 1;
    
    private Builder(Context paramContext)
    {
      mContext = paramContext;
    }
    
    public DiskCacheConfig build()
    {
      boolean bool;
      if ((mBaseDirectoryPathSupplier == null) && (mContext == null)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkState(bool, "Either a non-null context or a base directory path or supplier must be provided.");
      if ((mBaseDirectoryPathSupplier == null) && (mContext != null)) {
        mBaseDirectoryPathSupplier = new Supplier()
        {
          public File getFolder()
          {
            return mContext.getApplicationContext().getCacheDir();
          }
        };
      }
      return new DiskCacheConfig(this, null);
    }
    
    public Builder setBaseDirectoryName(String paramString)
    {
      mBaseDirectoryName = paramString;
      return this;
    }
    
    public Builder setBaseDirectoryPath(File paramFile)
    {
      mBaseDirectoryPathSupplier = Suppliers.cache(paramFile);
      return this;
    }
    
    public Builder setBaseDirectoryPathSupplier(Supplier paramSupplier)
    {
      mBaseDirectoryPathSupplier = paramSupplier;
      return this;
    }
    
    public Builder setCacheErrorLogger(CacheErrorLogger paramCacheErrorLogger)
    {
      mCacheErrorLogger = paramCacheErrorLogger;
      return this;
    }
    
    public Builder setCacheEventListener(CacheEventListener paramCacheEventListener)
    {
      mCacheEventListener = paramCacheEventListener;
      return this;
    }
    
    public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry paramDiskTrimmableRegistry)
    {
      mDiskTrimmableRegistry = paramDiskTrimmableRegistry;
      return this;
    }
    
    public Builder setEntryEvictionComparatorSupplier(EntryEvictionComparatorSupplier paramEntryEvictionComparatorSupplier)
    {
      mEntryEvictionComparatorSupplier = paramEntryEvictionComparatorSupplier;
      return this;
    }
    
    public Builder setIndexPopulateAtStartupEnabled(boolean paramBoolean)
    {
      mIndexPopulateAtStartupEnabled = paramBoolean;
      return this;
    }
    
    public Builder setMaxCacheSize(long paramLong)
    {
      mMaxCacheSize = paramLong;
      return this;
    }
    
    public Builder setMaxCacheSizeOnLowDiskSpace(long paramLong)
    {
      mMaxCacheSizeOnLowDiskSpace = paramLong;
      return this;
    }
    
    public Builder setMaxCacheSizeOnVeryLowDiskSpace(long paramLong)
    {
      mMaxCacheSizeOnVeryLowDiskSpace = paramLong;
      return this;
    }
    
    public Builder setVersion(int paramInt)
    {
      mVersion = paramInt;
      return this;
    }
  }
}
