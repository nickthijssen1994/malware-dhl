package cn.com.union.fido.bean.uafclient.policy;

import java.util.List;

/* loaded from: classes.dex */
public class Policy {
    private List<List<MatchCriteria>> accepted;
    private List<MatchCriteria> disallowed;

    public Policy() {
    }

    public Policy(List<List<MatchCriteria>> list, List<MatchCriteria> list2) {
        this.accepted = list;
        this.disallowed = list2;
    }

    public List<List<MatchCriteria>> getAccepted() {
        return this.accepted;
    }

    public List<MatchCriteria> getDisallowed() {
        return this.disallowed;
    }

    public void setAccepted(List<List<MatchCriteria>> list) {
        this.accepted = list;
    }

    public void setDisallowed(List<MatchCriteria> list) {
        this.disallowed = list;
    }
}
