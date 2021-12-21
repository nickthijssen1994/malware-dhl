package com.facebook.soloader;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public abstract class NativeLibrary
{
  private static final String Debug = "com.facebook.soloader.NativeLibrary";
  private boolean mLibrariesLoaded = false;
  @Nullable
  private List<String> mLibraryNames;
  @Nullable
  private volatile UnsatisfiedLinkError mLinkError = null;
  private Boolean mLoadLibraries = Boolean.valueOf(true);
  private final Object mLock = new Object();
  
  protected NativeLibrary(List paramList)
  {
    mLibraryNames = paramList;
  }
  
  public void ensureLoaded()
    throws UnsatisfiedLinkError
  {
    if (loadLibraries()) {
      return;
    }
    throw mLinkError;
  }
  
  public UnsatisfiedLinkError getError()
  {
    return mLinkError;
  }
  
  protected void initialNativeCheck()
    throws UnsatisfiedLinkError
  {}
  
  public boolean loadLibraries()
  {
    Object localObject1 = mLock;
    try
    {
      if (!mLoadLibraries.booleanValue())
      {
        bool = mLibrariesLoaded;
        return bool;
      }
      try
      {
        Object localObject2;
        if (mLibraryNames != null) {
          localObject2 = mLibraryNames;
        }
        Object localObject3;
        mLoadLibraries = Boolean.valueOf(false);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            bool = ((Iterator)localObject2).hasNext();
            if (!bool) {
              break;
            }
            localObject3 = ((Iterator)localObject2).next();
            localObject3 = (String)localObject3;
            SoLoader.loadLibrary((String)localObject3);
          }
          initialNativeCheck();
          mLibrariesLoaded = true;
          mLibraryNames = null;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          Log.e(Debug, "Failed to load native lib (initial check): ", localUnsatisfiedLinkError);
          mLinkError = localUnsatisfiedLinkError;
          mLibrariesLoaded = false;
        }
        localThrowable1 = localThrowable1;
        Log.e(Debug, "Failed to load native lib (other error): ", localThrowable1);
        mLinkError = new UnsatisfiedLinkError("Failed loading libraries");
        mLinkError.initCause(localThrowable1);
        mLibrariesLoaded = false;
      }
      boolean bool = mLibrariesLoaded;
      return bool;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
  }
}
