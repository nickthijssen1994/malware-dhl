package cn.com.union.fido.ui;

import android.app.Activity;

/* loaded from: classes.dex */
public interface IAuthSensorService {
    void endAuthenticator();

    void startAuthenticator(Activity activity, IAuthPresenter iAuthPresenter);
}
