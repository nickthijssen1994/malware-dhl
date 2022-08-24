package cn.com.union.fido.bean.uafclient;

import java.util.List;

/* loaded from: classes.dex */
public class RegistrationResponse {
    private List<AuthenticatorRegistrationAssertion> assertions;
    private String fcParams;
    private OperationHeader header;

    public List<AuthenticatorRegistrationAssertion> getAssertions() {
        return this.assertions;
    }

    public String getFcParams() {
        return this.fcParams;
    }

    public OperationHeader getHeader() {
        return this.header;
    }

    public void setAssertions(List<AuthenticatorRegistrationAssertion> list) {
        this.assertions = list;
    }

    public void setFcParams(String str) {
        this.fcParams = str;
    }

    public void setHeader(OperationHeader operationHeader) {
        this.header = operationHeader;
    }
}
