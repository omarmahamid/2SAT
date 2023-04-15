package com.omar.sat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SATSolver{


    public boolean solve(SAT sat){

        DirectedGraph<String> graph = buildGraph(sat);

        Kosaraju<String> kosaraju = new Kosaraju<>(graph);

        List<List<Vertex<String>>> sccs = kosaraju.findSCCs();

        for (List<Vertex<String>> adj : sccs){
            if (duplicateNegateLiteral(adj)){
                return false;
            }
        }

        return true;
    }


    private DirectedGraph<String> buildGraph(SAT sat){

        DirectedGraph<String> directedGraph = new DirectedGraph<>();

        for (Clause clause : sat.getClauses()){

            Vertex<String> v1 = new Vertex<>(clause.getL1().getId());
            Vertex<String> v2 = new Vertex<>(clause.getL2().getId());
            Vertex<String> negateV1 = new Vertex<>(Negate.negate(clause.getL2().getId()));
            Vertex<String> negateV2 = new Vertex<>(Negate.negate(clause.getL2().getId()));

            directedGraph.addVertex(v1);
            directedGraph.addVertex(v2);
            directedGraph.addVertex(negateV1);
            directedGraph.addVertex(negateV2);

            directedGraph.addEdge(negateV1, v2);
            directedGraph.addEdge(negateV2, v1);
        }

        return directedGraph;
    }


    private boolean duplicateNegateLiteral(List<Vertex<String>> adj){
        Set<String> vertices = new HashSet<>();
        for (Vertex<String> vertex : adj){
            vertices.add(vertex.getValue());
            if (vertices.contains(Negate.negate(vertex.getValue()))){
                return false;
            }
        }
        return true;
    }

}
