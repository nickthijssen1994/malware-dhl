package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

public abstract interface PlatformDecoder
{
  public abstract CloseableReference decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect);
  
  public abstract CloseableReference decodeFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect, ColorSpace paramColorSpace);
  
  public abstract CloseableReference decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect, int paramInt);
  
  public abstract CloseableReference decodeJPEGFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, Rect paramRect, int paramInt, ColorSpace paramColorSpace);
}
