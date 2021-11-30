package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class BaseConsumer<T>
  implements Consumer<T>
{
  private boolean mIsFinished = false;
  
  public BaseConsumer() {}
  
  public static boolean isLast(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean isNotLast(int paramInt)
  {
    return isLast(paramInt) ^ true;
  }
  
  public static int simpleStatusForIsLast(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static boolean statusHasAnyFlag(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public static boolean statusHasFlag(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  public static int turnOffStatusFlag(int paramInt1, int paramInt2)
  {
    return paramInt1 & paramInt2;
  }
  
  public static int turnOnStatusFlag(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public void onCancellation()
  {
    try
    {
      boolean bool = mIsFinished;
      if (bool) {
        return;
      }
      mIsFinished = true;
      try
      {
        onCancellationImpl();
      }
      catch (Exception localException)
      {
        onUnhandledException(localException);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected abstract void onCancellationImpl();
  
  public void onFailure(Throwable paramThrowable)
  {
    try
    {
      boolean bool = mIsFinished;
      if (bool) {
        return;
      }
      mIsFinished = true;
      try
      {
        onFailureImpl(paramThrowable);
      }
      catch (Exception paramThrowable)
      {
        onUnhandledException(paramThrowable);
      }
      return;
    }
    catch (Throwable paramThrowable)
    {
      throw paramThrowable;
    }
  }
  
  protected abstract void onFailureImpl(Throwable paramThrowable);
  
  public void onNewResult(Object paramObject, int paramInt)
  {
    try
    {
      boolean bool = mIsFinished;
      if (bool) {
        return;
      }
      mIsFinished = isLast(paramInt);
      try
      {
        onNewResultImpl(paramObject, paramInt);
      }
      catch (Exception paramObject)
      {
        onUnhandledException(paramObject);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  protected abstract void onNewResultImpl(Object paramObject, int paramInt);
  
  public void onProgressUpdate(float paramFloat)
  {
    try
    {
      boolean bool = mIsFinished;
      if (bool) {
        return;
      }
      try
      {
        onProgressUpdateImpl(paramFloat);
      }
      catch (Exception localException)
      {
        onUnhandledException(localException);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected void onProgressUpdateImpl(float paramFloat) {}
  
  protected void onUnhandledException(Exception paramException)
  {
    FLog.wtf(getClass(), "unhandled exception", paramException);
  }
}
