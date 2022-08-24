package cn.com.union.fido.bean.asm;

import cn.com.union.fido.bean.Version;
import cn.com.union.fido.bean.authenticator.DisplayPNGCharacteristicsDescriptor;
import java.util.List;

/* loaded from: classes.dex */
public class AuthenticatorInfo {
    public String aaid;
    public List<Version> asmVersions;
    public String assertionScheme;
    public long attachmentHint;
    public List<Short> attestationTypes;
    public int authenticationAlgorithm;
    public short authenticatorIndex;
    public String description;
    public boolean hasSettings;
    public String icon;
    public boolean isRoamingAuthenticator;
    public boolean isSecondFactorOnly;
    public boolean isUserEnrolled;
    public int keyProtection;
    public int matcherProtection;
    public List<String> supportedExtensionIDs;
    public int tcDisplay;
    public String tcDisplayContentType;
    public List<DisplayPNGCharacteristicsDescriptor> tcDisplayPNGCharacteristics;
    public String title;
    public long userVerification;
}
