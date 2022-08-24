package cn.com.union.fido.bean.authenticator;

/* loaded from: classes.dex */
public interface AuthenticatorStatusCode {
    public static final short UAF_CMD_STATUS_ACCESS_DENIED = 2;
    public static final short UAF_CMD_STATUS_ATTESTATION_NOT_SUPPORTED = 7;
    public static final short UAF_CMD_STATUS_CMD_NOT_SUPPORTED = 6;
    public static final short UAF_CMD_STATUS_ERR_UNKNOWN = 1;
    public static final short UAF_CMD_STATUS_FINGERS_CHANGE = 16;
    public static final short UAF_CMD_STATUS_KEYHANDLE_ERROR = 32;
    public static final short UAF_CMD_STATUS_OK = 0;
    public static final short UAF_CMD_STATUS_USER_CANCELLED = 5;
    public static final short UAF_CMD_STATUS_USER_INTERRUPTED = 33;
    public static final short UAF_CMD_STATUS_VERIFY_CHANGE_LOGIN_MODLE = 20;
    public static final short UAF_CMD_STATUS_VERIFY_ENROLLEDFINGERPRINTS_ERROR = 25;
    public static final short UAF_CMD_STATUS_VERIFY_HARDWARE_ERROR = 23;
    public static final short UAF_CMD_STATUS_VERIFY_KEYGUARDSECURE_ERROR = 24;
    public static final short UAF_CMD_STATUS_VERIFY_PERMISSION_ERROR = 22;
    public static final short UAF_CMD_STATUS_VERIFY_SDK_INT_ERROR = 21;
    public static final short UAF_CMD_STATUS_VERIFY_THREE_TIME_ERROR = 19;
    public static final short UAF_CMD_STATUS_VERIFY_TOO_MUCH_ERROR = 8;
}
