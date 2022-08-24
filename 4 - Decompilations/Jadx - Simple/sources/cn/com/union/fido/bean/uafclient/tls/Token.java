package cn.com.union.fido.bean.uafclient.tls;

/* loaded from: classes.dex */
public class Token {
    public TokenType type;
    public String value;

    public TokenType getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setType(TokenType tokenType) {
        this.type = tokenType;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
