package cn.com.union.fido.bean.uafclient;

import cn.com.union.fido.bean.uafclient.policy.Policy;

/* loaded from: classes.dex */
public class OperationRequest {
    private String challenge;
    private OperationHeader header;
    private Policy policy;

    public String getChallenge() {
        return this.challenge;
    }

    public OperationHeader getHeader() {
        return this.header;
    }

    public Policy getPolicy() {
        return this.policy;
    }

    public void setChallenge(String str) {
        this.challenge = str;
    }

    public void setHeader(OperationHeader operationHeader) {
        this.header = operationHeader;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
