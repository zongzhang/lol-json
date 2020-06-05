package org.lol.json;

/**
 * @since 1.0
 */
public class Element {
    Token token;
    Object value;

    public Element(Token token, Object value) {
        this.token = token;
        this.value = value;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
