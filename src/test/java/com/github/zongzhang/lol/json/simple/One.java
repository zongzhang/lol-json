package com.github.zongzhang.lol.json.simple;

import java.io.Serializable;

public class One implements Serializable {
    private static final long serialVersionUID = -4101541998169503505L;

    private String name;
    private boolean type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "One{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
