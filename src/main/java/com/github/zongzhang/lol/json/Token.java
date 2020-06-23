package com.github.zongzhang.lol.json;

/**
 * @since 1.0
 */
public enum Token {
    startObject(1),
    endObject(2),
    startArray(3),
    endArray(4),
    comma(5),//逗号
    colon(6),//冒号
    nullWord(7),
    trueWord(8),
    falseWord(9),
    booleanType(10),
    stringType(11),
    numericType(12),
    unknown(13),
    EOF(14);

    private final int index;

    Token(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
