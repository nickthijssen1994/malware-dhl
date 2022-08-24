package cn.com.union.fido.bean.asm;

import cn.com.union.fido.bean.Extension;
import cn.com.union.fido.bean.Version;
import java.util.List;

/* loaded from: classes.dex */
public class ASMRequest {
    public Object args;
    public Version asmVersion;
    public Short authenticatorIndex;
    public List<Extension> exts;
    public Request requestType;

    public Object getArgs() {
        return this.args;
    }

    public Version getAsmVersion() {
        return this.asmVersion;
    }

    public Short getAuthenticatorIndex() {
        return this.authenticatorIndex;
    }

    public List<Extension> getExts() {
        return this.exts;
    }

    public Request getRequestType() {
        return this.requestType;
    }

    public void setArgs(Object obj) {
        this.args = obj;
    }

    public void setAsmVersion(Version version) {
        this.asmVersion = version;
    }

    public void setAuthenticatorIndex(Short sh) {
        this.authenticatorIndex = sh;
    }

    public void setExts(List<Extension> list) {
        this.exts = list;
    }

    public void setRequestType(Request request) {
        this.requestType = request;
    }
}
