package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface CloseableReferenceLeakTracker {

    /* loaded from: classes.dex */
    public interface Listener {
        void onCloseableReferenceLeak(SharedReference<Object> sharedReference, @Nullable Throwable th);
    }

    boolean isSet();

    void setListener(@Nullable Listener listener);

    void trackCloseableReferenceLeak(SharedReference<Object> sharedReference, @Nullable Throwable th);
}
