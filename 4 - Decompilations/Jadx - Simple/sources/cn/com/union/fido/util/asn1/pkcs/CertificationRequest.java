package cn.com.union.fido.util.asn1.pkcs;

import cn.com.union.fido.util.asn1.ASN1Encodable;
import cn.com.union.fido.util.asn1.ASN1EncodableVector;
import cn.com.union.fido.util.asn1.ASN1Sequence;
import cn.com.union.fido.util.asn1.DERBitString;
import cn.com.union.fido.util.asn1.DERObject;
import cn.com.union.fido.util.asn1.DERSequence;
import cn.com.union.fido.util.asn1.x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class CertificationRequest extends ASN1Encodable {
    protected CertificationRequestInfo reqInfo;
    protected AlgorithmIdentifier sigAlgId;
    protected DERBitString sigBits;

    /* JADX INFO: Access modifiers changed from: protected */
    public CertificationRequest() {
        this.reqInfo = null;
        this.sigAlgId = null;
        this.sigBits = null;
    }

    public CertificationRequest(ASN1Sequence aSN1Sequence) {
        this.reqInfo = null;
        this.sigAlgId = null;
        this.sigBits = null;
        this.reqInfo = CertificationRequestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.sigBits = (DERBitString) aSN1Sequence.getObjectAt(2);
    }

    public CertificationRequest(CertificationRequestInfo certificationRequestInfo, AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString) {
        this.reqInfo = null;
        this.sigAlgId = null;
        this.sigBits = null;
        this.reqInfo = certificationRequestInfo;
        this.sigAlgId = algorithmIdentifier;
        this.sigBits = dERBitString;
    }

    public static CertificationRequest getInstance(Object obj) {
        if (obj instanceof CertificationRequest) {
            return (CertificationRequest) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertificationRequest((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertificationRequestInfo getCertificationRequestInfo() {
        return this.reqInfo;
    }

    public DERBitString getSignature() {
        return this.sigBits;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    @Override // cn.com.union.fido.util.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.reqInfo);
        aSN1EncodableVector.add(this.sigAlgId);
        aSN1EncodableVector.add(this.sigBits);
        return new DERSequence(aSN1EncodableVector);
    }
}
