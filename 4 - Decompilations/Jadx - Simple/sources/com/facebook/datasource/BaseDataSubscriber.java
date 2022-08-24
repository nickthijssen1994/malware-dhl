package com.facebook.datasource;

import javax.annotation.Nonnull;

/* loaded from: classes.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    protected abstract void onCancelImpl(@Nonnull DataSource<T> dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(@Nonnull DataSource<T> dataSource) {
        try {
            onCancelImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(@Nonnull DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }

    protected abstract void onFailureImpl(@Nonnull DataSource<T> dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(@Nonnull DataSource<T> dataSource) {
        boolean isFinished = dataSource.isFinished();
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (isFinished) {
                dataSource.close();
            }
        }
    }

    protected abstract void onNewResultImpl(@Nonnull DataSource<T> dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(@Nonnull DataSource<T> dataSource) {
    }
}
