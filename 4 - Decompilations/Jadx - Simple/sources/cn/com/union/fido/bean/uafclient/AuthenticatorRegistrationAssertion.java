package cn.com.union.fido.bean.uafclient;

import cn.com.union.fido.bean.Extension;
import cn.com.union.fido.bean.authenticator.DisplayPNGCharacteristicsDescriptor;
import java.util.List;

/* loaded from: classes.dex */
public class AuthenticatorRegistrationAssertion {
    private String assertion;
    private String assertionScheme;
    private List<Extension> exts;
    private List<DisplayPNGCharacteristicsDescriptor> tcDisplayPNGCharacteristics;

    public AuthenticatorRegistrationAssertion() {
    }

    public AuthenticatorRegistrationAssertion(String str, String str2, List<DisplayPNGCharacteristicsDescriptor> list, List<Extension> list2) {
        this.assertionScheme = str;
        this.assertion = str2;
        this.tcDisplayPNGCharacteristics = list;
        this.exts = list2;
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

    public List<DisplayPNGCharacteristicsDescriptor> getTcDisplayPNGCharacteristics() {
        return this.tcDisplayPNGCharacteristics;
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

    public void setTcDisplayPNGCharacteristics(List<DisplayPNGCharacteristicsDescriptor> list) {
        this.tcDisplayPNGCharacteristics = list;
    }
}
