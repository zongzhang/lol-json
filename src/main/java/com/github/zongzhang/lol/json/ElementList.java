package com.github.zongzhang.lol.json;

import java.util.Iterator;
import java.util.List;

/**
 * @since 1.0
 */
public class ElementList implements Iterator<Element> {
    private final List<Element> list;
    private int index = 0;

    public ElementList(List<Element> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Element next() {
        return list.get(index++);
    }

}
