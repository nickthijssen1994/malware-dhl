package cn.com.union.fido.bean.authenticator.tag;

import cn.com.union.fido.util.Utility;

/* loaded from: classes.dex */
public class TAG_AUTHENTICATOR_METADATA {
    public short authenticationAlg;
    public short authenticatorType;
    public short keyProtection;
    public short matcherProtection;
    public byte maxKeyHandles;
    public short tcDisplay;
    public int userVerification;

    public void deserialize(byte[] bArr) {
        this.authenticatorType = (short) Utility.byteToShort(bArr, 0, 2);
        this.maxKeyHandles = bArr[2];
        this.userVerification = Utility.byteToInt(bArr, 3, 7);
        this.keyProtection = (short) Utility.byteToShort(bArr, 7, 9);
        this.matcherProtection = (short) Utility.byteToShort(bArr, 9, 11);
        this.tcDisplay = (short) Utility.byteToShort(bArr, 11, 13);
        this.authenticationAlg = (short) Utility.byteToShort(bArr, 13, 15);
    }

    public byte[] serialize() {
        byte[] bArr = new byte[128];
        Utility.shortToByte(bArr, 0, 2, this.authenticatorType);
        bArr[2] = this.maxKeyHandles;
        Utility.intToByte(bArr, 3, 7, this.userVerification);
        Utility.shortToByte(bArr, 7, 9, this.keyProtection);
        Utility.shortToByte(bArr, 9, 11, this.matcherProtection);
        Utility.shortToByte(bArr, 11, 13, this.tcDisplay);
        Utility.shortToByte(bArr, 13, 15, this.authenticationAlg);
        byte[] bArr2 = new byte[15];
        System.arraycopy(bArr, 0, bArr2, 0, 15);
        return bArr2;
    }
}
