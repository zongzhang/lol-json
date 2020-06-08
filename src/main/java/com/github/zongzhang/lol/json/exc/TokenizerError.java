package com.github.zongzhang.lol.json.exc;

/**
 * @since 1.0
 */
public enum TokenizerError {
    None(0),
    UnexpectedEndOfComment(1),
    UnexpectedEndOfString(2),
    UnexpectedEndOfNumber(3),
    InvalidUnicode(4),
    InvalidEscapeCharacter(5),
    InvalidCharacter(6);

    private final int code;

    TokenizerError(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
