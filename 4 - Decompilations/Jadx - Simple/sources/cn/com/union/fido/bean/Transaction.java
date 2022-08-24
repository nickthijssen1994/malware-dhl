package cn.com.union.fido.bean;

import cn.com.union.fido.bean.authenticator.DisplayPNGCharacteristicsDescriptor;

/* loaded from: classes.dex */
public class Transaction {
    private String content;
    private String contentType;
    private DisplayPNGCharacteristicsDescriptor tcDisplayPNGCharacteristics;

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public DisplayPNGCharacteristicsDescriptor getTcDisplayPNGCharacteristics() {
        return this.tcDisplayPNGCharacteristics;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setTcDisplayPNGCharacteristics(DisplayPNGCharacteristicsDescriptor displayPNGCharacteristicsDescriptor) {
        this.tcDisplayPNGCharacteristics = displayPNGCharacteristicsDescriptor;
    }
}
