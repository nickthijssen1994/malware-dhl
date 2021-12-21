package com.facebook.imagepipeline.systrace;

import javax.annotation.Nullable;

public class FrescoSystrace
{
  public static final ArgsBuilder NO_OP_ARGS_BUILDER = new NoOpArgsBuilder(null);
  @Nullable
  private static volatile Systrace sInstance = null;
  
  private FrescoSystrace() {}
  
  public static void beginSection(String paramString)
  {
    getInstance().beginSection(paramString);
  }
  
  public static ArgsBuilder beginSectionWithArgs(String paramString)
  {
    return getInstance().beginSectionWithArgs(paramString);
  }
  
  public static void endSection()
  {
    getInstance().endSection();
  }
  
  private static Systrace getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new DefaultFrescoSystrace();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return sInstance;
  }
  
  public static boolean isTracing()
  {
    return getInstance().isTracing();
  }
  
  public static void provide(Systrace paramSystrace)
  {
    sInstance = paramSystrace;
  }
  
  public static abstract interface ArgsBuilder
  {
    public abstract ArgsBuilder doImport(String paramString, double paramDouble);
    
    public abstract ArgsBuilder expand(String paramString, int paramInt);
    
    public abstract ArgsBuilder expand(String paramString, long paramLong);
    
    public abstract ArgsBuilder expand(String paramString, Object paramObject);
    
    public abstract void flush();
  }
  
  private static final class NoOpArgsBuilder
    implements FrescoSystrace.ArgsBuilder
  {
    private NoOpArgsBuilder() {}
    
    public FrescoSystrace.ArgsBuilder doImport(String paramString, double paramDouble)
    {
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder expand(String paramString, int paramInt)
    {
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder expand(String paramString, long paramLong)
    {
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder expand(String paramString, Object paramObject)
    {
      return this;
    }
    
    public void flush() {}
  }
  
  public static abstract interface Systrace
  {
    public abstract void beginSection(String paramString);
    
    public abstract FrescoSystrace.ArgsBuilder beginSectionWithArgs(String paramString);
    
    public abstract void endSection();
    
    public abstract boolean isTracing();
  }
}
