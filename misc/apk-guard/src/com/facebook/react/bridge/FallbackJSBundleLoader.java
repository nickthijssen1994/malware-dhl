package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public final class FallbackJSBundleLoader
  extends JSBundleLoader
{
  static final String PAGE_KEY = "FallbackJSBundleLoader";
  static final String RECOVERABLE = "facebook::react::Recoverable";
  private Stack<JSBundleLoader> mLoaders = new Stack();
  private final ArrayList<Exception> mRecoveredErrors = new ArrayList();
  
  public FallbackJSBundleLoader(List paramList)
  {
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious()) {
      mLoaders.push(paramList.previous());
    }
  }
  
  private JSBundleLoader getDelegateLoader()
  {
    if (!mLoaders.empty()) {
      return (JSBundleLoader)mLoaders.peek();
    }
    RuntimeException localRuntimeException = new RuntimeException("No fallback options available");
    Iterator localIterator = mRecoveredErrors.iterator();
    Object localObject1 = localRuntimeException;
    if (localIterator.hasNext())
    {
      Object localObject2 = (Exception)localIterator.next();
      ((Throwable)localObject1).initCause((Throwable)localObject2);
      for (localObject2 = localObject1;; localObject2 = ((Throwable)localObject2).getCause())
      {
        localObject1 = localObject2;
        if (((Throwable)localObject2).getCause() == null) {
          break;
        }
      }
    }
    throw localRuntimeException;
  }
  
  public String loadScript(JSBundleLoaderDelegate paramJSBundleLoaderDelegate)
  {
    try
    {
      String str = getDelegateLoader().loadScript(paramJSBundleLoaderDelegate);
      return str;
    }
    catch (Exception localException)
    {
      while ((localException.getMessage() != null) && (localException.getMessage().startsWith("facebook::react::Recoverable")))
      {
        mLoaders.pop();
        mRecoveredErrors.add(localException);
        FLog.wtf("FallbackJSBundleLoader", "Falling back from recoverable error", localException);
      }
      throw localException;
    }
  }
}
