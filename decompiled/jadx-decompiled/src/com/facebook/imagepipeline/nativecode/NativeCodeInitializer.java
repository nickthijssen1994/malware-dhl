package com.facebook.imagepipeline.nativecode;

import android.content.Context;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* loaded from: classes.dex */
public class NativeCodeInitializer {
    @DoNotStrip
    public static void init(Context context) {
        SoLoader.init(context, 0);
    }
}
