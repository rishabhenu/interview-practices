package org.example.util;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V> {

    public final Map<K, V> map;

    public static <K, V> MapBuilder<K, V> builder() {
        return new MapBuilder<>(new HashMap<>());
    }

    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        return map;
    }

    public MapBuilder(Map<K, V> map) {
        this.map = map;
    }
}
