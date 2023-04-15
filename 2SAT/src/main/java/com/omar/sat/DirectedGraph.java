package com.omar.sat;

import java.util.*;


/**
 * adjacency technique
 * */
public class DirectedGraph<V>{


    private final Map<Vertex<V>, List<Vertex<V>>> adjacencyList;

    public DirectedGraph(){
        adjacencyList = new LinkedHashMap<>();
    }


    public boolean addEdge(Vertex<V> v1, Vertex<V> v2){
        if (!adjacencyList.containsKey(v1)){
            return false;
        }
        List<Vertex<V>> adj = adjacencyList.get(v1);
        adj.add(v2);
        return true;
    }


    public void addVertex(Vertex<V> vertex){
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public Map<Vertex<V>, List<Vertex<V>>> getAdjacencyList() {
        return adjacencyList;
    }
}
