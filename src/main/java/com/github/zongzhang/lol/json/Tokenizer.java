package com.github.zongzhang.lol.json;

import com.github.zongzhang.lol.json.utils.CharsCode;
import com.github.zongzhang.lol.json.exc.JsnException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @since 1.0
 */
public class Tokenizer {
    private final char[] chars;
    private final ArrayList<Element> tokens = new ArrayList<>();
    private int pos;
    private final int len;

    public Tokenizer(String text) {
        this.chars = text.toCharArray();
        this.pos = 0;
        this.len = chars.length;
    }

    public List<Element> tokenize() {
        Element element;
        while (pos < len) {
            element = mark();
            tokens.add(element);
        }
        return tokens;
    }

    private void skipWhitespace() {
        while (pos < len) {
            if (CharsCode.isWhitespace(chars[pos])) {
                pos++;
            } else {
                break;
            }
        }
    }

    private Element mark() {
        skipWhitespace();
        char ch = chars[pos];
        pos++;
        switch (ch) {
            case '{':
                return new Element(Token.startObject, null);
            case '}':
                return new Element(Token.endObject, null);
            case '[':
                return new Element(Token.startArray, null);
            case ']':
                return new Element(Token.endArray, null);
            case ',':
                return new Element(Token.comma, null);
            case ':':
                return new Element(Token.colon, null);
            case 'n':
                return readNull();
            case 't':
                return readTrue();
            case 'f':
                return readFalse();
            case CharsCode.doubleQuotes:
                return readString();
            case CharsCode.minus:
            case CharsCode._0:
            case CharsCode._1:
            case CharsCode._2:
            case CharsCode._3:
            case CharsCode._4:
            case CharsCode._5:
            case CharsCode._6:
            case CharsCode._7:
            case CharsCode._8:
            case CharsCode._9:
                return readNumeric();
        }
        throw new JsnException("Illegal character");
    }

    private Element readNull() {
        pos = pos + 3;
        return new Element(Token.nullWord, null);
    }

    private Element readTrue() {
        pos = pos + 3;
        return new Element(Token.trueWord, true);
    }

    private Element readFalse() {
        pos = pos + 4;
        return new Element(Token.falseWord, false);
    }

    private Element readString() {
        int start = pos;
        int end = pos;
        while (pos < len) {
            pos++;
            if (chars[pos] == CharsCode.doubleQuotes) {
                end = pos;
                pos++;
                break;
            }
        }
        return new Element(Token.stringType, new String(Arrays.copyOfRange(chars, start, end)));
    }

    private Element readNumeric() {
        int start = pos;
        if (chars[pos] == CharsCode._0) {
            pos++;
        } else {
            pos++;
            while (pos < len && CharsCode.isDigit(chars[pos])) {
                pos++;
            }
        }
        if (pos < len && chars[pos] == CharsCode.dot) {
            pos++;
            if (pos < len && CharsCode.isDigit(chars[pos])) {
                pos++;
                while (pos < len && CharsCode.isDigit(chars[pos])) {
                    pos++;
                }
            } else {
                throw new JsnException("unexpected end of number");
            }
        }
        int end = pos;
        if (pos < len && (chars[pos] == CharsCode.E || chars[pos] == CharsCode.e)) {
            pos++;
            if (pos < len && chars[pos] == CharsCode.plus || chars[pos] == CharsCode.minus) {
                pos++;
            }
            if (pos < len && CharsCode.isDigit(chars[pos])) {
                pos++;
                while (pos < len && CharsCode.isDigit(chars[pos])) {
                    pos++;
                }
                end = pos;
            } else {
                throw new JsnException("unexpected end of number");
            }
        }
        return new Element(Token.numericType, new String(Arrays.copyOfRange(chars, start, end)));
    }
}
