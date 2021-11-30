package com.facebook.cache.common;

import android.net.Uri;
import javax.annotation.Nullable;

public class DebuggingCacheKey
  extends SimpleCacheKey
{
  @Nullable
  private final Object mCallerContext;
  private final Uri mSourceUri;
  
  public DebuggingCacheKey(String paramString, Object paramObject, Uri paramUri)
  {
    super(paramString);
    mCallerContext = paramObject;
    mSourceUri = paramUri;
  }
  
  public Object getCallerContext()
  {
    return mCallerContext;
  }
  
  public Uri getSourceUri()
  {
    return mSourceUri;
  }
}
