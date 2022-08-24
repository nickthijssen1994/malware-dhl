package cn.com.union.fido.ui;

/* loaded from: classes.dex */
public interface IFidoView {
    void authViewDisplay(String str);

    void onAuthenticationError(String str);

    void onAuthenticationFailed(String str);

    void onAuthenticationHelp(String str, CharSequence charSequence);

    void onAuthenticationSucceeded(String str);
}
