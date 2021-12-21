package com.airbnb.lottie;

import android.graphics.Bitmap;

public abstract interface ImageAssetDelegate
{
  public abstract Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset);
}
