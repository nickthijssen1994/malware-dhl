package cn.com.union.fido.util.asn1;

/* loaded from: classes.dex */
public class ASN1ParsingException extends IllegalStateException {
    private Throwable cause;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1ParsingException(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1ParsingException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
