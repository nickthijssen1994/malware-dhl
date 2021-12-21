package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.soloader.nativeloader.NativeLoader;

/* loaded from: classes.dex */
public class StaticWebpNativeLoader {
    private static boolean sInitialized;

    public static synchronized void ensure() {
        synchronized (StaticWebpNativeLoader.class) {
            if (!sInitialized) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        NativeLoader.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError unused) {
                    }
                }
                NativeLoader.loadLibrary("static-webp");
                sInitialized = true;
            }
        }
    }
}
