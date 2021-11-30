package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class LottieResult<V>
{
  @Nullable
  private final Throwable exception;
  @Nullable
  private final V value;
  
  public LottieResult(Object paramObject)
  {
    value = paramObject;
    exception = null;
  }
  
  public LottieResult(Throwable paramThrowable)
  {
    exception = paramThrowable;
    value = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LottieResult)) {
      return false;
    }
    paramObject = (LottieResult)paramObject;
    if ((getValue() != null) && (getValue().equals(paramObject.getValue()))) {
      return true;
    }
    if ((getException() != null) && (paramObject.getException() != null)) {
      return getException().toString().equals(getException().toString());
    }
    return false;
  }
  
  public Throwable getException()
  {
    return exception;
  }
  
  public Object getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { getValue(), getException() });
  }
}
