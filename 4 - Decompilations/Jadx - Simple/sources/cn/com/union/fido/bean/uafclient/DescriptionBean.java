package cn.com.union.fido.bean.uafclient;

/* loaded from: classes.dex */
public class DescriptionBean {
    public AuthenticatorsSucBean authenticatorsSucceeded;
    public String statusMsg;

    public AuthenticatorsSucBean getAuthenticatorsSucceeded() {
        return this.authenticatorsSucceeded;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public void setAuthenticatorsSucceeded(AuthenticatorsSucBean authenticatorsSucBean) {
        this.authenticatorsSucceeded = authenticatorsSucBean;
    }

    public void setStatusMsg(String str) {
        this.statusMsg = str;
    }
}
