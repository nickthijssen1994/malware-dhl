package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public abstract interface KeyPathElement
{
  public abstract void addValueCallback(Object paramObject, LottieValueCallback paramLottieValueCallback);
  
  public abstract void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List paramList, KeyPath paramKeyPath2);
}
