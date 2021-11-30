package com.facebook.imagepipeline.animated.impl;

import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

/* loaded from: classes.dex */
public interface AnimatedDrawableBackendProvider {
    AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect);
}
