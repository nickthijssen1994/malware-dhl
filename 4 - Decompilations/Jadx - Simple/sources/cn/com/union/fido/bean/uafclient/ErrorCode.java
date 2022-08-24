package cn.com.union.fido.bean.uafclient;

/* loaded from: classes.dex */
public interface ErrorCode {
    public static final short AUTH_FAILED = 8;
    public static final short CHANGE_LOGIN_MODLE = 22;
    public static final short ENROLLEDFINGERPRINTS_ERROR = 36;
    public static final short FACETID_NULL = 9;
    public static final short FINGERS_CHANGE = 18;
    public static final short FINGERUI_DISPLAY = 153;
    public static final short FINGER_LOGIN_ON = 49;
    public static final short FINGER_ON = 48;
    public static final short FINGER_PAYMENT_ON = 50;
    public static final short HARDWARE_ERROR = 34;
    public static final short INSECURE_TRANSPORT = 2;
    public static final short KEYGUARDSECURE_ERROR = 35;
    public static final short KEYHANDLE_ERROR = 23;
    public static final short NO_ERROR = 0;
    public static final short NO_SUITABLE_AUTHENTICATOR = 5;
    public static final short PERMISSION_ERROR = 33;
    public static final short PROTOCOL_ERROR = 6;
    public static final short RETRY_HW_UNAVAILABLE = 17;
    public static final short SDK_INT_ERROR = 32;
    public static final short UNKNOWN = 255;
    public static final short UNREGISERED_FACED_ID = 7;
    public static final short UNSUPPORTED_VERSION = 4;
    public static final short USER_CANCELLED = 3;
    public static final short USER_INTERRUPTED = 24;
    public static final short VERIFY_THREE_TIME_ERROR = 19;
    public static final short VERIFY_TOO_MUCH_ERROR = 16;
    public static final short WAIT_USER_ACTION = 1;
}
