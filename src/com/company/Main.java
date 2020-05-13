package com.company;

public class Main {

    public static void main(String[] args) {

        Graph graph=new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.dfs(0);
        graph.bfs(0);
        System.out.println(graph.isCyclic());
    }
}
