package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface BitmapTransformation {
    boolean modifiesTransparency();

    void transform(Bitmap bitmap);
}
