package com.company;

public class Main {

    public static void main(String[] args) {

        Graph graph=new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.dfs(0);
    }
}
