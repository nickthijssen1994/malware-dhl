package cn.com.union.fido.bean.uafclient;

import cn.com.union.fido.bean.Version;
import java.util.List;

/* loaded from: classes.dex */
public class TrustedFacets {
    List<String> ids;
    Version version;

    public List<String> getIds() {
        return this.ids;
    }

    public Version getVersion() {
        return this.version;
    }

    public void setIds(List<String> list) {
        this.ids = list;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
