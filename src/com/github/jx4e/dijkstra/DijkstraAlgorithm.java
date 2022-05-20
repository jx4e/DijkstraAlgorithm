package com.github.jx4e.dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        dijkstra();
    }

    public static void dijkstra() {
        List<Node> queue = new LinkedList<>();
        Queue<Node> dequeued = new LinkedList<>();

        populateGraph(queue);
        queue.sort(DijkstraAlgorithm::sort);

        while (!queue.isEmpty()) {
            Node removed = queue.remove(0);
            dequeued.add(removed);
            for (Map.Entry<String, Integer> entry : removed.edges.entrySet()) {
                List<Node> connected = queue.stream()
                        .filter(n -> n.name.equals(entry.getKey()))
                        .collect(Collectors.toList());

                if (connected.isEmpty()) continue;

                connected.forEach(n -> n.value = Math.min(n.value, entry.getValue() + removed.value));
                queue.sort(DijkstraAlgorithm::sort);
            }
        }

        dequeued.forEach(n -> System.out.println("Node " + n.name + ", Shortest Distance: " + n.value));
    }

    public static int sort(Node n1, Node n2) {
        return Integer.compare(n1.value, n2.value);
    }

    public static void populateGraph(List<Node> graph) {
        EdgeBuilder e = new EdgeBuilder();

        // Create our nodes
        Node A = new Node(
                "A",
                e.clear().put("B", 4).put("D", 4).put("E", 8).get()
        );

        Node B = new Node(
                "B",
                e.clear().put("A", 4).put("5", 4).put("E", 1).get()
        );

        Node C = new Node(
                "C",
                e.clear().put("B", 5).put("D", 6).put("E", 3).put("F", 2).put("G", 7).get()
        );

        Node D = new Node(
                "D",
                e.clear().put("A", 4).put("C", 6).put("E", 5).put("F", 3).get()
        );

        Node E = new Node(
                "E",
                e.clear().put("A", 8).put("B", 1).put("C", 3).put("D", 5).get()
        );

        Node F = new Node(
                "F",
                e.clear().put("C", 2).put("D", 3).put("G", 4).get()
        );

        Node G = new Node(
                "G",
                e.clear().put("C", 7).put("F", 4).get()
        );

        // Setup start node by giving it a value of 0
        A.setValue(0);

        // Populate the graph
        graph.addAll(Arrays.asList(A, B, C, D, E, F, G));
    }
}
