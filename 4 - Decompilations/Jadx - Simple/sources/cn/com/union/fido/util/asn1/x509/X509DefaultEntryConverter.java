package cn.com.union.fido.util.asn1.x509;

import cn.com.union.fido.util.asn1.DERGeneralizedTime;
import cn.com.union.fido.util.asn1.DERIA5String;
import cn.com.union.fido.util.asn1.DERObject;
import cn.com.union.fido.util.asn1.DERObjectIdentifier;
import cn.com.union.fido.util.asn1.DERPrintableString;
import cn.com.union.fido.util.asn1.DERUTF8String;
import java.io.IOException;

/* loaded from: classes.dex */
public class X509DefaultEntryConverter extends X509NameEntryConverter {
    @Override // cn.com.union.fido.util.asn1.x509.X509NameEntryConverter
    public DERObject getConvertedValue(DERObjectIdentifier dERObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return (dERObjectIdentifier.equals(X509Name.EmailAddress) || dERObjectIdentifier.equals(X509Name.DC)) ? new DERIA5String(str) : dERObjectIdentifier.equals(X509Name.DATE_OF_BIRTH) ? new DERGeneralizedTime(str) : (dERObjectIdentifier.equals(X509Name.C) || dERObjectIdentifier.equals(X509Name.SN) || dERObjectIdentifier.equals(X509Name.DN_QUALIFIER) || dERObjectIdentifier.equals(X509Name.TELEPHONE_NUMBER)) ? new DERPrintableString(str) : new DERUTF8String(str);
        }
        try {
            return convertHexEncoded(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + dERObjectIdentifier.getId());
        }
    }
}
