package com.github.zongzhang.lol.json;

import org.junit.Test;

/**
 * Unit test for lol-json.
 */
public class AppTest {

    @Test
    public void testParser() {
        String json = "{\"name\": \"Ashley\", \"type\": false}";
        JSN jsn = new JSN();
        Object o = jsn.of(json);
        System.out.println(o);
    }
}
