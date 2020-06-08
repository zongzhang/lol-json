package com.github.zongzhang.lol.json;

import com.github.zongzhang.lol.json.exc.JsnException;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 1.0
 */
public class JsnObject {
    private final Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public JsnObject getJsonObject(String key) {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Invalid key");
        }
        Object obj = map.get(key);
        if (!(obj instanceof JsnObject)) {
            throw new JsnException("Type of value is not JsonObject");
        }
        return (JsnObject) obj;
    }

    public JsnArray getJsonArray(String key) {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Invalid key");
        }
        Object obj = map.get(key);
        if (!(obj instanceof JsnArray)) {
            throw new JsnException("Type of value is not JsonArray");
        }
        return (JsnArray) obj;
    }
}
