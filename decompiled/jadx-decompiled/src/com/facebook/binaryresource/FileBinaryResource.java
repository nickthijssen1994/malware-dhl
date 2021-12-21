package com.facebook.binaryresource;

import com.facebook.common.internal.Files;
import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class FileBinaryResource implements BinaryResource {
    private final File mFile;

    private FileBinaryResource(File file) {
        this.mFile = (File) Preconditions.checkNotNull(file);
    }

    @Nullable
    public static FileBinaryResource createOrNull(File file) {
        if (file != null) {
            return new FileBinaryResource(file);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return this.mFile.equals(((FileBinaryResource) obj).mFile);
    }

    public File getFile() {
        return this.mFile;
    }

    public int hashCode() {
        return this.mFile.hashCode();
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() {
        return new FileInputStream(this.mFile);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] read() {
        return Files.toByteArray(this.mFile);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.mFile.length();
    }
}
