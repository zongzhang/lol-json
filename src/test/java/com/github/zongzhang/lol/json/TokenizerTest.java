package com.github.zongzhang.lol.json;

import org.junit.Test;

import java.util.List;

/**
 * @since 1.0
 */
public class TokenizerTest {

    @Test
    public void testTokenize() {
        String json = "{\"name\": \"Ashley\", \"type\": false}";
        Tokenizer tokenizer = new Tokenizer(json);
        List<Element> list = tokenizer.tokenize();
        System.out.println(list);
    }


    @Test
    public void testTokenizeNumber() {
        String json = "{\"a\": 12}";
        Tokenizer tokenizer = new Tokenizer(json);
        List<Element> list = tokenizer.tokenize();
        System.out.println(list);
    }
}
