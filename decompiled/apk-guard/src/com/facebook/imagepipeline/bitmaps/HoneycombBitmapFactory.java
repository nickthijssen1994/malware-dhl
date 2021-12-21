package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
public class HoneycombBitmapFactory
  extends PlatformBitmapFactory
{
  private static final String HASHTAG = "HoneycombBitmapFactory";
  private final CloseableReferenceFactory mCloseableReferenceFactory;
  private boolean mImmutableBitmapFallback;
  private final EmptyJpegGenerator mJpegGenerator;
  private final PlatformDecoder mPurgeableDecoder;
  
  public HoneycombBitmapFactory(EmptyJpegGenerator paramEmptyJpegGenerator, PlatformDecoder paramPlatformDecoder, CloseableReferenceFactory paramCloseableReferenceFactory)
  {
    mJpegGenerator = paramEmptyJpegGenerator;
    mPurgeableDecoder = paramPlatformDecoder;
    mCloseableReferenceFactory = paramCloseableReferenceFactory;
  }
  
  private CloseableReference createFallbackBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return mCloseableReferenceFactory.create(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig), SimpleBitmapReleaser.getInstance());
  }
  
  /* Error */
  public CloseableReference createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mImmutableBitmapFallback	Z
    //   4: ifeq +11 -> 15
    //   7: aload_0
    //   8: iload_1
    //   9: iload_2
    //   10: aload_3
    //   11: invokespecial 60	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:createFallbackBitmap	(IILandroid/graphics/Bitmap$Config;)Lcom/facebook/common/references/CloseableReference;
    //   14: areturn
    //   15: aload_0
    //   16: getfield 29	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   19: iload_1
    //   20: i2s
    //   21: iload_2
    //   22: i2s
    //   23: invokevirtual 66	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   26: astore 5
    //   28: new 68	com/facebook/imagepipeline/image/EncodedImage
    //   31: dup
    //   32: aload 5
    //   34: invokespecial 71	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   37: astore 6
    //   39: aload 6
    //   41: getstatic 77	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   44: invokevirtual 81	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   47: aload_0
    //   48: getfield 31	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mPurgeableDecoder	Lcom/facebook/imagepipeline/platform/PlatformDecoder;
    //   51: aload 6
    //   53: aload_3
    //   54: aconst_null
    //   55: aload 5
    //   57: invokevirtual 87	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   60: checkcast 89	com/facebook/common/memory/PooledByteBuffer
    //   63: invokeinterface 93 1 0
    //   68: invokeinterface 99 5 0
    //   73: astore 7
    //   75: aload 7
    //   77: invokevirtual 87	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   80: checkcast 37	android/graphics/Bitmap
    //   83: invokevirtual 103	android/graphics/Bitmap:isMutable	()Z
    //   86: istore 4
    //   88: iload 4
    //   90: ifne +41 -> 131
    //   93: aload 7
    //   95: invokestatic 106	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 58	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mImmutableBitmapFallback	Z
    //   103: getstatic 108	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:HASHTAG	Ljava/lang/String;
    //   106: ldc 110
    //   108: invokestatic 116	com/facebook/common/logging/FLog:wtf	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: iload_1
    //   113: iload_2
    //   114: aload_3
    //   115: invokespecial 60	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:createFallbackBitmap	(IILandroid/graphics/Bitmap$Config;)Lcom/facebook/common/references/CloseableReference;
    //   118: astore_3
    //   119: aload 6
    //   121: invokestatic 119	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   124: aload 5
    //   126: invokevirtual 122	com/facebook/common/references/CloseableReference:close	()V
    //   129: aload_3
    //   130: areturn
    //   131: aload 7
    //   133: invokevirtual 87	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   136: checkcast 37	android/graphics/Bitmap
    //   139: iconst_1
    //   140: invokevirtual 126	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   143: aload 7
    //   145: invokevirtual 87	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   148: checkcast 37	android/graphics/Bitmap
    //   151: iconst_0
    //   152: invokevirtual 130	android/graphics/Bitmap:eraseColor	(I)V
    //   155: aload 6
    //   157: invokestatic 119	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   160: aload 5
    //   162: invokevirtual 122	com/facebook/common/references/CloseableReference:close	()V
    //   165: aload 7
    //   167: areturn
    //   168: astore_3
    //   169: aload 6
    //   171: invokestatic 119	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: aload 5
    //   179: invokevirtual 122	com/facebook/common/references/CloseableReference:close	()V
    //   182: aload_3
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	HoneycombBitmapFactory
    //   0	184	1	paramInt1	int
    //   0	184	2	paramInt2	int
    //   0	184	3	paramConfig	Bitmap.Config
    //   86	3	4	bool	boolean
    //   26	152	5	localCloseableReference1	CloseableReference
    //   37	133	6	localEncodedImage	com.facebook.imagepipeline.image.EncodedImage
    //   73	93	7	localCloseableReference2	CloseableReference
    // Exception table:
    //   from	to	target	type
    //   47	88	168	java/lang/Throwable
    //   93	119	168	java/lang/Throwable
    //   131	155	168	java/lang/Throwable
    //   28	47	176	java/lang/Throwable
    //   119	124	176	java/lang/Throwable
    //   155	160	176	java/lang/Throwable
    //   169	176	176	java/lang/Throwable
  }
}
