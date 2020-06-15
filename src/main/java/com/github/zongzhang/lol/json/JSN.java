package com.github.zongzhang.lol.json;


import com.github.zongzhang.lol.json.exc.JsnException;

import java.util.ArrayList;

/**
 * @since 1.0
 */
public class JSN {
    private ElementList iterator;

    public Object of(String text) {
        Tokenizer tokenizer = new Tokenizer(text);
        ArrayList<Element> elements = (ArrayList<Element>) tokenizer.tokenize();
        iterator = new ElementList(elements);
        Token startToken = elements.get(0).getToken();
        switch (startToken) {
            case startObject:
                return parseObject();
            case startArray:
                return parseArray();
            default:
                throw new JsnException("parse error, invalid json.");
        }
    }

    private Object parseObject() {
        JsnObject jsonObject = new JsnObject();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            Token token = element.getToken();
            switch (token) {
                case startObject:
                    Element nextElement = iterator.next();
                    String key = (String) nextElement.getValue();
                    Object value = parseObject();
                    jsonObject.put(key, value);
                    break;
                case stringType:
                    Element stringNext = iterator.next();
                    Token stringNextToken = stringNext.getToken();
                    if (stringNextToken == Token.colon) {
                        String key1 = (String) element.getValue();
                        Object o1 = parseObject();
                        jsonObject.put(key1, o1);
                        break;
                    } else {
                        return element.getValue();
                    }
                case colon:
                    //冒号
                    break;
                case comma:
                    //逗号
                    break;
                case trueWord:
                    return true;
                case falseWord:
                    return false;
                case nullWord:
                    return null;
                case EOF:
                case endObject:
                    return jsonObject;
                default:
                    throw new JsnException("Unexpected Json.");
            }
        }
        return jsonObject;
    }

    private Object parseArray() {
        JsnArray jsnArray = new JsnArray();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            Token token = element.getToken();
            switch (token) {
                case startArray:
                case comma:
                    //逗号
                    break;
                default:
                    throw new JsnException("Unexpected Json.");
            }
        }
        return jsnArray;
    }
}
