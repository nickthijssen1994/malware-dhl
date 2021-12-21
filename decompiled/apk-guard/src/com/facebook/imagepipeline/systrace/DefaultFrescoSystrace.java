package com.facebook.imagepipeline.systrace;

import android.os.Build.VERSION;
import android.os.Trace;

public class DefaultFrescoSystrace
  implements FrescoSystrace.Systrace
{
  public DefaultFrescoSystrace() {}
  
  public void beginSection(String paramString) {}
  
  public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String paramString)
  {
    return FrescoSystrace.NO_OP_ARGS_BUILDER;
  }
  
  public void endSection() {}
  
  public boolean isTracing()
  {
    return false;
  }
  
  private static final class DefaultArgsBuilder
    implements FrescoSystrace.ArgsBuilder
  {
    private final StringBuilder mStringBuilder;
    
    public DefaultArgsBuilder(String paramString)
    {
      mStringBuilder = new StringBuilder(paramString);
    }
    
    public FrescoSystrace.ArgsBuilder doImport(String paramString, double paramDouble)
    {
      StringBuilder localStringBuilder = mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      localStringBuilder.append(Double.toString(paramDouble));
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder expand(String paramString, int paramInt)
    {
      StringBuilder localStringBuilder = mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      localStringBuilder.append(Integer.toString(paramInt));
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder expand(String paramString, long paramLong)
    {
      StringBuilder localStringBuilder = mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      localStringBuilder.append(Long.toString(paramLong));
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder expand(String paramString, Object paramObject)
    {
      StringBuilder localStringBuilder = mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      if (paramObject == null) {
        paramString = "null";
      } else {
        paramString = paramObject.toString();
      }
      localStringBuilder.append(paramString);
      return this;
    }
    
    public void flush()
    {
      if (mStringBuilder.length() > 127) {
        mStringBuilder.setLength(127);
      }
      if (Build.VERSION.SDK_INT >= 18) {
        Trace.beginSection(mStringBuilder.toString());
      }
    }
  }
}
