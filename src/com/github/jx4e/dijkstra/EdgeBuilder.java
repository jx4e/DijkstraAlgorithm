package com.github.jx4e.dijkstra;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to help with building weighted graphs
 */
public class EdgeBuilder {
    public Map<String, Integer> map;

    public EdgeBuilder() {
        this.map = new HashMap<>();
    }

    public EdgeBuilder clear() {
        map = new HashMap<>();
        return this;
    }

    public EdgeBuilder put(String s, Integer i) {
        map.put(s, i);
        return this;
    }

    public Map<String, Integer> get() {
        return map;
    }
}
