package com.github.zongzhang.lol.json.utils;

/**
 * @since 1.0
 */
public class CharsCode {
    public static final int space = 0x0020; //半角空格
    public static final int space_1 = 0x3000; //全角空格
    public static final int space_2 = 0x00A0; //不间断空
    public static final int tab = 0x0009;


    public static final int dot = 0x002e;

    public static final int _0 = 0x0030;
    public static final int _1 = 0x0031;
    public static final int _2 = 0x0032;
    public static final int _3 = 0x0033;
    public static final int _4 = 0x0034;
    public static final int _5 = 0x0035;
    public static final int _6 = 0x0036;
    public static final int _7 = 0x0037;
    public static final int _8 = 0x0038;
    public static final int _9 = 0x0039;

    public static final int e = 0x0065;
    public static final int E = 0x0045;

    public static final int plus = 0x002b;
    public static final int minus = 0x002d;

    public static final int doubleQuotes = 0x0022;


    public static boolean isDigit(int ch) {
        return ch >= _0 && ch <= _9;
    }

    public static boolean isWhitespace(int ch) {
        return ch == space
                || ch == space_1
                || ch == space_2
                || ch == tab;
    }
}
