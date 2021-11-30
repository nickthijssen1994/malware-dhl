package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class DefaultDrawableFactory
  implements DrawableFactory
{
  @Nullable
  private final DrawableFactory mAnimatedDrawableFactory;
  private final Resources mResources;
  
  public DefaultDrawableFactory(Resources paramResources, DrawableFactory paramDrawableFactory)
  {
    mResources = paramResources;
    mAnimatedDrawableFactory = paramDrawableFactory;
  }
  
  private static boolean hasTransformableExifOrientation(CloseableStaticBitmap paramCloseableStaticBitmap)
  {
    return (paramCloseableStaticBitmap.getExifOrientation() != 1) && (paramCloseableStaticBitmap.getExifOrientation() != 0);
  }
  
  private static boolean hasTransformableRotationAngle(CloseableStaticBitmap paramCloseableStaticBitmap)
  {
    return (paramCloseableStaticBitmap.getRotationAngle() != 0) && (paramCloseableStaticBitmap.getRotationAngle() != -1);
  }
  
  public Drawable createDrawable(CloseableImage paramCloseableImage)
  {
    Object localObject;
    try
    {
      boolean bool = FrescoSystrace.isTracing();
      if (bool) {
        FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");
      }
      bool = paramCloseableImage instanceof CloseableStaticBitmap;
      if (bool)
      {
        paramCloseableImage = (CloseableStaticBitmap)paramCloseableImage;
        localObject = new BitmapDrawable(mResources, paramCloseableImage.getUnderlyingBitmap());
        bool = hasTransformableRotationAngle(paramCloseableImage);
        if (!bool)
        {
          bool = hasTransformableExifOrientation(paramCloseableImage);
          if (!bool)
          {
            if (!FrescoSystrace.isTracing()) {
              break label169;
            }
            FrescoSystrace.endSection();
            return localObject;
          }
        }
        paramCloseableImage = new OrientedDrawable((Drawable)localObject, paramCloseableImage.getRotationAngle(), paramCloseableImage.getExifOrientation());
        if (!FrescoSystrace.isTracing()) {
          break label171;
        }
        FrescoSystrace.endSection();
        return paramCloseableImage;
      }
      else
      {
        localObject = mAnimatedDrawableFactory;
        if (localObject != null)
        {
          bool = mAnimatedDrawableFactory.supportsImageType(paramCloseableImage);
          if (bool)
          {
            paramCloseableImage = mAnimatedDrawableFactory.createDrawable(paramCloseableImage);
            if (!FrescoSystrace.isTracing()) {
              break label173;
            }
            FrescoSystrace.endSection();
            return paramCloseableImage;
          }
        }
        if (!FrescoSystrace.isTracing()) {
          break label175;
        }
        FrescoSystrace.endSection();
        return null;
      }
    }
    catch (Throwable paramCloseableImage)
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      throw paramCloseableImage;
    }
    label169:
    return localObject;
    label171:
    return paramCloseableImage;
    label173:
    return paramCloseableImage;
    label175:
    return null;
  }
  
  public boolean supportsImageType(CloseableImage paramCloseableImage)
  {
    return true;
  }
}
