package cn.com.union.fido.bean;

/* loaded from: classes.dex */
public class SecCheckResult {
    public byte[] extraData;
    public byte[] signedData;

    public SecCheckResult(byte[] bArr, byte[] bArr2) {
        this.extraData = bArr;
        this.signedData = bArr2;
    }
}
