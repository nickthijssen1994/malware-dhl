package cn.com.union.fido.bean.uafclient;

import cn.com.union.fido.bean.uafclient.tls.ChannelBinding;

/* loaded from: classes.dex */
public class FinalChallengeParams {
    public String appID;
    public String challenge;
    public ChannelBinding channelBinding;
    public String facetID;

    public FinalChallengeParams(String str, String str2, String str3, ChannelBinding channelBinding) {
        this.appID = str;
        this.challenge = str2;
        this.facetID = str3;
        this.channelBinding = channelBinding;
    }
}
