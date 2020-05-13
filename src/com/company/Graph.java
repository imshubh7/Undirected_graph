package com.company;

import java.util.*;
public class Graph {

    ArrayList<Integer>graph[];
    int V;

    public Graph(int n)
    {
        this.graph=new ArrayList[n];
        V=n;
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
    }

    public void addEdge(int u,int v)
    {
        graph[u].add(v);
        graph[v].add(u);
    }

    public void dfs(int root,boolean visited[])
    {
        System.out.print(root+"=>");
        visited[root]=true;
        for(int i=0;i<graph[root].size();i++)
        {
            if(!visited[graph[root].get(i)])
            {
                dfs(graph[root].get(i),visited);
            }
        }
        return;
    }

    public void dfs(int root)
    {
        boolean visited[]=new boolean[V];
        dfs(root,visited);
        return;
    }

}
