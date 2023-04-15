package com.omar.sat;

import java.util.*;

public class Kosaraju<V>{

    private final DirectedGraph<V> graph;

    public Kosaraju(DirectedGraph<V> graph) {
        this.graph = graph;
    }

    public List<List<Vertex<V>>> findSCCs() {

        List<List<Vertex<V>>> sccs = new ArrayList<>();
        Stack<Vertex<V>> stack = new Stack<>();
        Set<Vertex<V>> visited = new HashSet<>();

        // Step 1: Perform DFS and add vertices to stack in the order of their finish times
        for (Vertex<V> vertex : graph.getAdjacencyList().keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited, stack);
            }
        }

        // Step 2: Transpose the graph
        DirectedGraph<V> transposeGraph = transposeGraph(graph);

        // Step 3: Perform DFS in the order of vertices in the stack and collect SCCs
        visited.clear();
        while (!stack.isEmpty()) {
            Vertex<V> vertex = stack.pop();
            if (!visited.contains(vertex)) {
                List<Vertex<V>> scc = new ArrayList<>();
                dfs(transposeGraph, vertex, visited, scc);
                sccs.add(scc);
            }
        }

        return sccs;
    }

    private void dfs(Vertex<V> vertex, Set<Vertex<V>> visited, Stack<Vertex<V>> stack) {
        visited.add(vertex);
        for (Vertex<V> neighbor : graph.getAdjacencyList().get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }

    private void dfs(DirectedGraph<V> graph, Vertex<V> vertex, Set<Vertex<V>> visited, List<Vertex<V>> scc) {
        visited.add(vertex);
        scc.add(vertex);
        for (Vertex<V> neighbor : graph.getAdjacencyList().get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, scc);
            }
        }
    }

    private DirectedGraph<V> transposeGraph(DirectedGraph<V> graph) {
        DirectedGraph<V> transposeGraph = new DirectedGraph<>();
        for (Vertex<V> vertex : graph.getAdjacencyList().keySet()) {
            transposeGraph.addVertex(vertex);
        }
        for (Map.Entry<Vertex<V>, List<Vertex<V>>> entry : graph.getAdjacencyList().entrySet()) {
            Vertex<V> vertex = entry.getKey();
            for (Vertex<V> neighbor : entry.getValue()) {
                transposeGraph.addEdge(new Vertex<>(neighbor.getValue()), new Vertex<>(vertex.getValue()));
            }
        }
        return transposeGraph;
    }

}
