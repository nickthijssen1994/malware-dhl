package com.facebook.cache.common;

import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class NoOpCacheEventListener implements CacheEventListener {
    @Nullable
    private static NoOpCacheEventListener sInstance;

    private NoOpCacheEventListener() {
    }

    public static synchronized NoOpCacheEventListener getInstance() {
        NoOpCacheEventListener noOpCacheEventListener;
        synchronized (NoOpCacheEventListener.class) {
            if (sInstance == null) {
                sInstance = new NoOpCacheEventListener();
            }
            noOpCacheEventListener = sInstance;
        }
        return noOpCacheEventListener;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onCleared() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onEviction(CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onHit(CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onMiss(CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onReadException(CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteAttempt(CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteException(CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteSuccess(CacheEvent cacheEvent) {
    }
}
