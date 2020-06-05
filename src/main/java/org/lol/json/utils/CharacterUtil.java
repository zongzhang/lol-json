package org.lol.json.utils;

/**
 * @since 1.0
 */
public class CharacterUtil {
    static final int space = 0x0020;
    static final int tab = 0x09;

    public static boolean isWhitespace(int ch) {
        return ch == CharacterUtil.space || ch == CharacterUtil.tab;
    }
}
