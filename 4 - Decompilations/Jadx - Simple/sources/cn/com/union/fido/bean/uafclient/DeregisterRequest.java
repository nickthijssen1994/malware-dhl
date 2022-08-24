package cn.com.union.fido.bean.uafclient;

import java.util.List;

/* loaded from: classes.dex */
public class DeregisterRequest extends OperationRequest {
    private List<DeregisterAuthenticator> authenticators;

    public List<DeregisterAuthenticator> getAuthenticators() {
        return this.authenticators;
    }

    public void setAuthenticators(List<DeregisterAuthenticator> list) {
        this.authenticators = list;
    }
}
