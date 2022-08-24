package com.huawei.hmf.tasks;

/* loaded from: classes.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable runnable);
}
