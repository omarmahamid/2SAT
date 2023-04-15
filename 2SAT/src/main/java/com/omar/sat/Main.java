package com.omar.sat;

public class Main{

    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<>();

        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);

        graph.addEdge(A,B);
        graph.addEdge(A,C);
        graph.addEdge(B,D);
        graph.addEdge(C,D);

    }

}
