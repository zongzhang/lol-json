package com.github.zongzhang.lol.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 1.0
 */
public class JsnArray {
    private final List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public Object get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
