package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface ImageTranscoderFactory {
    @Nullable
    ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z);
}
