package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class ObjectAlreadyConsumedException
  extends RuntimeException
{
  public ObjectAlreadyConsumedException(String paramString)
  {
    super(paramString);
  }
}
