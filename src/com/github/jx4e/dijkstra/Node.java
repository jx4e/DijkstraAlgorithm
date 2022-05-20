package com.github.jx4e.dijkstra;

import java.util.Map;

public class Node {
    public final String name;
    public final Map<String, Integer> edges;
    public int value;

    public Node(String name, Map<String, Integer> edges) {
        this.name = name;
        this.edges = edges;
        value = Integer.MAX_VALUE;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", edges=" + edges +
                ", value=" + value +
                '}';
    }
}
