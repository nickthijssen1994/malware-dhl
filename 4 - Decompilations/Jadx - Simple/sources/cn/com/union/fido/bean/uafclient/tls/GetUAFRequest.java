package cn.com.union.fido.bean.uafclient.tls;

import cn.com.union.fido.bean.uafclient.Operation;

/* loaded from: classes.dex */
public class GetUAFRequest {
    private String context;
    private Operation op;
    private String previousRequest;

    public String getContext() {
        return this.context;
    }

    public Operation getOp() {
        return this.op;
    }

    public String getPreviousRequest() {
        return this.previousRequest;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public void setOp(Operation operation) {
        this.op = operation;
    }

    public void setPreviousRequest(String str) {
        this.previousRequest = str;
    }
}
