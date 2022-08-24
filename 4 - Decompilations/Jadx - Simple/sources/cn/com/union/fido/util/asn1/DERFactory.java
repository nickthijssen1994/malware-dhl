package cn.com.union.fido.util.asn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DERFactory {
    static final DERSequence EMPTY_SEQUENCE = new DERSequence();
    static final DERSet EMPTY_SET = new DERSet();

    DERFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() <= 0 ? EMPTY_SEQUENCE : new DERSequence(aSN1EncodableVector);
    }

    static DERSet createSet(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() <= 0 ? EMPTY_SET : new DERSet(aSN1EncodableVector);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DERSet createSet(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        return aSN1EncodableVector.size() <= 0 ? EMPTY_SET : new DERSet(aSN1EncodableVector, z);
    }
}
