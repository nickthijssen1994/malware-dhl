package cn.com.union.fido.bean.asm;

import cn.com.union.fido.bean.Extension;
import java.util.List;

/* loaded from: classes.dex */
public class ASMResponse {
    public List<Extension> exts;
    public Object responseData;
    public short statusCode;

    public List<Extension> getExts() {
        return this.exts;
    }

    public Object getResponseData() {
        return this.responseData;
    }

    public short getStatusCode() {
        return this.statusCode;
    }

    public void setExts(List<Extension> list) {
        this.exts = list;
    }

    public void setResponseData(Object obj) {
        this.responseData = obj;
    }

    public void setStatusCode(short s) {
        this.statusCode = s;
    }
}
