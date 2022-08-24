package cn.com.union.fido.bean.uafclient;

import cn.com.union.fido.bean.Extension;
import cn.com.union.fido.bean.Version;
import java.util.List;

/* loaded from: classes.dex */
public class OperationHeader {
    private String appID;
    private List<Extension> exts;
    private String op;
    private String serverData;
    private Version upv;

    public String getAppID() {
        return this.appID;
    }

    public List<Extension> getExts() {
        return this.exts;
    }

    public String getOp() {
        return this.op;
    }

    public String getServerData() {
        return this.serverData;
    }

    public Version getUpv() {
        return this.upv;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setExts(List<Extension> list) {
        this.exts = list;
    }

    public void setOp(String str) {
        this.op = str;
    }

    public void setServerData(String str) {
        this.serverData = str;
    }

    public void setUpv(Version version) {
        this.upv = version;
    }
}
