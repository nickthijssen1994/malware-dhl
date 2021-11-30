package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

public class SimpleBitmapReleaser
  implements ResourceReleaser<Bitmap>
{
  private static SimpleBitmapReleaser sInstance;
  
  private SimpleBitmapReleaser() {}
  
  public static SimpleBitmapReleaser getInstance()
  {
    if (sInstance == null) {
      sInstance = new SimpleBitmapReleaser();
    }
    return sInstance;
  }
  
  public void release(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
}
