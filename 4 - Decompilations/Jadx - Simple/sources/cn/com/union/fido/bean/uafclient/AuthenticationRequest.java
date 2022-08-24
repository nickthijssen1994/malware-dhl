package cn.com.union.fido.bean.uafclient;

import cn.com.union.fido.bean.Transaction;
import java.util.List;

/* loaded from: classes.dex */
public class AuthenticationRequest extends OperationRequest {
    private List<Transaction> transaction;

    public List<Transaction> getTransaction() {
        return this.transaction;
    }

    public void setTransaction(List<Transaction> list) {
        this.transaction = list;
    }
}
