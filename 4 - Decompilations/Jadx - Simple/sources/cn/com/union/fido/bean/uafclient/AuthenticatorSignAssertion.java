package cn.com.union.fido.bean.uafclient;

import cn.com.union.fido.bean.Extension;
import java.util.List;

/* loaded from: classes.dex */
public class AuthenticatorSignAssertion {
    private String assertion;
    private String assertionScheme;
    private List<Extension> exts;

    public AuthenticatorSignAssertion() {
    }

    public AuthenticatorSignAssertion(String str, String str2, List<Extension> list) {
        this.assertionScheme = str;
        this.assertion = str2;
        this.exts = list;
    }

    public String getAssertion() {
        return this.assertion;
    }

    public String getAssertionScheme() {
        return this.assertionScheme;
    }

    public List<Extension> getExts() {
        return this.exts;
    }

    public void setAssertion(String str) {
        this.assertion = str;
    }

    public void setAssertionScheme(String str) {
        this.assertionScheme = str;
    }

    public void setExts(List<Extension> list) {
        this.exts = list;
    }
}
