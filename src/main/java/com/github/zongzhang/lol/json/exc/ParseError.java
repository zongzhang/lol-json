package com.github.zongzhang.lol.json.exc;

/**
 * @since 1.0
 */
public enum ParseError {
    InvalidSymbol(1),
    InvalidNumberFormat(2),
    PropertyNameExpected(3),
    ValueExpected(4),
    ColonExpected(5),
    CommaExpected(6),
    CloseBraceExpected(7),
    CloseBracketExpected(8),
    EndOfFileExpected(9),
    InvalidCommentToken(10),
    UnexpectedEndOfComment(11),
    UnexpectedEndOfString(12),
    UnexpectedEndOfNumber(13),
    InvalidUnicode(14),
    InvalidEscapeCharacter(15),
    InvalidCharacter(16);

    private final int code;

    ParseError(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
