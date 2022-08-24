package cn.com.union.fido.util.asn1.x509;

import cn.com.union.fido.util.asn1.ASN1Encodable;
import cn.com.union.fido.util.asn1.ASN1EncodableVector;
import cn.com.union.fido.util.asn1.ASN1Sequence;
import cn.com.union.fido.util.asn1.ASN1TaggedObject;
import cn.com.union.fido.util.asn1.DEREncodable;
import cn.com.union.fido.util.asn1.DERObject;
import cn.com.union.fido.util.asn1.DERObjectIdentifier;
import cn.com.union.fido.util.asn1.DERSequence;

/* loaded from: classes.dex */
public class AlgorithmIdentifier extends ASN1Encodable {
    private DERObjectIdentifier objectId;
    private DEREncodable parameters;
    private boolean parametersDefined;

    public AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        DEREncodable dEREncodable;
        this.parametersDefined = false;
        if (aSN1Sequence.size() <= 0 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.objectId = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.parametersDefined = true;
            dEREncodable = aSN1Sequence.getObjectAt(1);
        } else {
            dEREncodable = null;
        }
        this.parameters = dEREncodable;
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier) {
        this.parametersDefined = false;
        this.objectId = dERObjectIdentifier;
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.parametersDefined = false;
        this.parametersDefined = true;
        this.objectId = dERObjectIdentifier;
        this.parameters = dEREncodable;
    }

    public AlgorithmIdentifier(String str) {
        this.parametersDefined = false;
        this.objectId = new DERObjectIdentifier(str);
    }

    public static AlgorithmIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static AlgorithmIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof AlgorithmIdentifier)) {
            return (AlgorithmIdentifier) obj;
        }
        if (obj instanceof DERObjectIdentifier) {
            return new AlgorithmIdentifier((DERObjectIdentifier) obj);
        }
        if (obj instanceof String) {
            return new AlgorithmIdentifier((String) obj);
        }
        if (obj instanceof ASN1Sequence) {
            return new AlgorithmIdentifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public DERObjectIdentifier getObjectId() {
        return this.objectId;
    }

    public DEREncodable getParameters() {
        return this.parameters;
    }

    @Override // cn.com.union.fido.util.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.objectId);
        if (this.parametersDefined) {
            aSN1EncodableVector.add(this.parameters);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
