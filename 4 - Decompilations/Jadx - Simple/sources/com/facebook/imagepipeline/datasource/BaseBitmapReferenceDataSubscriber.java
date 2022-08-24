package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class BaseBitmapReferenceDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    protected abstract void onNewResultImpl(@Nullable CloseableReference<Bitmap> closeableReference);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(@Nonnull DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.isFinished()) {
            CloseableReference<CloseableImage> result = dataSource.getResult();
            CloseableReference<Bitmap> closeableReference = null;
            if (result != null && (result.get() instanceof CloseableStaticBitmap)) {
                closeableReference = ((CloseableStaticBitmap) result.get()).cloneUnderlyingBitmapReference();
            }
            try {
                onNewResultImpl(closeableReference);
            } finally {
                CloseableReference.closeSafely(closeableReference);
                CloseableReference.closeSafely(result);
            }
        }
    }
}
