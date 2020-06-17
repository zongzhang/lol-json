package com.github.zongzhang.lol.json;

import org.junit.Test;

/**
 * Unit test for lol-json.
 */
public class AppTest {

    @Test
    public void testParser() {
        String json = "{\"jianzhi\": \"zifu\", \"buer\": false}";
        JSN jsn = new JSN();
        Object o = jsn.of(json);
        System.out.println(o);
    }

    @Test
    public void testArrayParser() {
        String json = "[\"jianzhi\", \"buer\"]";
        JSN jsn = new JSN();
        Object o = jsn.of(json);
        System.out.println(o);
    }
}
