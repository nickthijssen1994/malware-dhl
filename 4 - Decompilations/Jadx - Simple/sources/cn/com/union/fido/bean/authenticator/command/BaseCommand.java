package cn.com.union.fido.bean.authenticator.command;

import cn.com.union.fido.util.Utility;

/* loaded from: classes.dex */
public class BaseCommand {
    public short cmd;

    public BaseCommand() {
    }

    public BaseCommand(short s) {
        this.cmd = s;
    }

    public void deserialize(byte[] bArr) {
        this.cmd = (short) Utility.byteToShort(bArr, 0, 2);
    }

    public byte[] serialize() {
        return null;
    }
}
