package cn.com.union.fido.bean.uafclient;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SimpleAuth implements Serializable {
    private static final long serialVersionUID = 4431579533186598671L;
    private String aaid;
    private short authenticatorIndex;
    private String description;
    private String icon;
    private String title;

    public String getAaid() {
        return this.aaid;
    }

    public short getAuthenticatorIndex() {
        return this.authenticatorIndex;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAaid(String str) {
        this.aaid = str;
    }

    public void setAuthenticatorIndex(short s) {
        this.authenticatorIndex = s;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
