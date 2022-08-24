package cn.com.union.fido.bean.asm;

import cn.com.union.fido.bean.Transaction;
import java.util.List;

/* loaded from: classes.dex */
public class AuthenticateIn {
    public String appID;
    public String finalChallenge;
    public List<String> keyIDs;
    public List<Transaction> transaction;
}
