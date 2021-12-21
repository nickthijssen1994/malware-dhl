package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap.Config;
import com.facebook.soloader.DoNotOptimize;

@DoNotOptimize
class PreverificationHelper
{
  PreverificationHelper() {}
  
  boolean shouldUseHardwareBitmapConfig(Bitmap.Config paramConfig)
  {
    return paramConfig == Enum.HARDWARE;
  }
}
