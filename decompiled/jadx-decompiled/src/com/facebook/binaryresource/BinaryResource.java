package com.facebook.binaryresource;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface BinaryResource {
    InputStream openStream();

    byte[] read();

    long size();
}
