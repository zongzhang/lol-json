package com.github.zongzhang.lol.json;

import com.github.zongzhang.lol.json.utils.CharacterUtil;
import com.github.zongzhang.lol.json.exc.JsnException;

import java.util.ArrayList;
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
            pos++;
        }
        return tokens;
    }

    private void skipWhitespace() {
        while (pos < len) {
            if (CharacterUtil.isWhitespace(chars[pos])) {
                pos++;
            } else {
                break;
            }
        }
    }

    private Element mark() {
        skipWhitespace();
        char ch = chars[pos];
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
            case '"':
                return readString();
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return readNumber();
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
        StringBuilder sb = new StringBuilder();
        while (pos < len) {
            pos++;
            if (chars[pos] == '"') {
                break;
            }
            sb.append(chars[pos]);
        }
        return new Element(Token.stringType, sb.toString());
    }

    private Element readNumber() {
        int start = pos;
        if (chars[pos] == CharacterUtil._0) {
            pos++;
        } else {
            pos++;
            while (pos < len && CharacterUtil.isDigit(chars[pos])) {
                pos++;
            }
        }
        if (pos < len && chars[pos] == CharacterUtil.dot) {
            pos++;
            if (pos < len && CharacterUtil.isDigit(chars[pos])) {
                pos++;
                while (pos < len && CharacterUtil.isDigit(chars[pos])) {
                    pos++;
                }
            } else {
                throw new JsnException("unexpected end of number");
            }
        }
        int end = pos;
        if (pos < len && (chars[pos] == CharacterUtil.E || chars[pos] == CharacterUtil.e)) {
            pos++;
            if (pos < len && chars[pos] == CharacterUtil.plus || chars[pos] == CharacterUtil.minus) {
                pos++;
            }
            if (pos < len && CharacterUtil.isDigit(chars[pos])) {
                pos++;
                while (pos < len && CharacterUtil.isDigit(chars[pos])) {
                    pos++;
                }
                end = pos;
            } else {
                throw new JsnException("unexpected end of number");
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(chars[i]);
        }
        return new Element(Token.numericType, sb.toString());
    }
}
