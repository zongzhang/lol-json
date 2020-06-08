package com.github.zongzhang.lol.json;


import com.github.zongzhang.lol.json.exc.JsnException;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 1.0
 */
public class JSN {
    List<Element> elements = new ArrayList<>();

    public Object of(String text) {
        Tokenizer tokenizer = new Tokenizer(text);
        elements = tokenizer.tokenize();
        return parseObject();
    }

    private Object parseObject() {
        JsnObject jsonObject = new JsnObject();

        Token startToken = elements.get(0).getToken();
        if (startToken != Token.startObject) {
            throw new JsnException("Parse error, invalid Json.");
        }

        String key = null;
        Object value;
        for (int i = 1; i < elements.size(); i++) {
            Token token = elements.get(i).getToken();
            Object tokenValue = elements.get(i).getValue();
            int next = i + 1;
            Token nextToken = null;
            if (next < elements.size()) {
                nextToken = elements.get(next).getToken();
            }
            switch (token) {
                case stringType: {
                    if (nextToken == Token.colon) {
                        key = (String) tokenValue;
                    } else {
                        value = tokenValue;
                        jsonObject.put(key, value);
                    }
                    break;
                }
                case colon:
                case comma:
                    break;
                case endObject:
                    return jsonObject;

                case trueWord: {
                    jsonObject.put(key, true);
                    break;
                }
                case falseWord: {
                    jsonObject.put(key, false);
                    break;
                }
                default:
                    throw new JsnException("Unexpected Json.");
            }
        }
        return jsonObject;
    }
}
