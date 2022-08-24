package cn.com.union.fido.bean;

/* loaded from: classes.dex */
public class Extension {
    private String data;
    private boolean fail_if_unknown;
    private String id;

    public String getData() {
        return this.data;
    }

    public String getId() {
        return this.id;
    }

    public boolean isFail_if_unknown() {
        return this.fail_if_unknown;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setFail_if_unknown(boolean z) {
        this.fail_if_unknown = z;
    }

    public void setId(String str) {
        this.id = str;
    }
}
