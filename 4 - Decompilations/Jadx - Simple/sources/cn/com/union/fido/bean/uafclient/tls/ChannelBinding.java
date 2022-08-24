package cn.com.union.fido.bean.uafclient.tls;

import com.jdjr.risk.jdcn.common.utils.FsGsonUtil;

/* loaded from: classes.dex */
public class ChannelBinding {
    private String cid_pubkey;
    private String serverEndPoint;
    private String tlsServerCertificate;
    private String tlsUnique;

    public void fromJSON(String str) {
        ChannelBinding channelBinding = (ChannelBinding) FsGsonUtil.gsonToBean(str, ChannelBinding.class);
        this.serverEndPoint = channelBinding.getServerEndPoint();
        this.tlsServerCertificate = channelBinding.getTlsServerCertificate();
        this.tlsUnique = channelBinding.getTlsUnique();
        this.cid_pubkey = channelBinding.getCid_pubkey();
    }

    public String getCid_pubkey() {
        return this.cid_pubkey;
    }

    public String getServerEndPoint() {
        return this.serverEndPoint;
    }

    public String getTlsServerCertificate() {
        return this.tlsServerCertificate;
    }

    public String getTlsUnique() {
        return this.tlsUnique;
    }

    public void setCid_pubkey(String str) {
        this.cid_pubkey = str;
    }

    public void setServerEndPoint(String str) {
        this.serverEndPoint = str;
    }

    public void setTlsServerCertificate(String str) {
        this.tlsServerCertificate = str;
    }

    public void setTlsUnique(String str) {
        this.tlsUnique = str;
    }
}
