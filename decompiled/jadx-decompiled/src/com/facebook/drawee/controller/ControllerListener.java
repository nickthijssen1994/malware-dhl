package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface ControllerListener<INFO> {
    void onCancelled();

    void onFailure(String str, Throwable th);

    void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable, Drawable drawable);

    void onIntermediateImageFailed(String str, Throwable th);

    void onIntermediateImageSet(String str, @Nullable INFO info);

    void onRelease(String str);

    void onStart();

    void onSubmit(String str, Object obj);
}
