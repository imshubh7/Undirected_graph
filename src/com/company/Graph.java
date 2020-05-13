package com.company;

import java.util.*;
public class Graph {

    ArrayList<Integer>graph[];
    int V;

    //GRAPH CONSTRUCTOR
    public Graph(int v)
    {
        graph=new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            graph[i]=new ArrayList<>();
        }
        V=v;
    }

    // ADDING THE EDGES
    public void addEdge(int u,int v)
    {
        graph[u].add(v);
        graph[v].add(u);
    }

    // DFS CALLED FROM MAIN
    public void dfs(int root)
    {
        boolean vis[]=new boolean[V];
        System.out.println("DFS Running...");
        dfs(root,vis);
    }

    //INBUILT HELPER DFS FUNCTION WITH VISITED ARRAY
    public void dfs(int root,boolean vis[])
    {
        vis[root]=true;
        System.out.println(root);
        for(int i=0;i<graph[root].size();i++)
        {
            if(!vis[graph[root].get(i)])
            {
                dfs(graph[root].get(i),vis);
            }
        }
    }

    //BFS FUNCTION USING QUEUE
    public void bfs(int root)
    {
        boolean vis[]=new boolean[V];
        System.out.println("BFS Running...");

        Queue<Integer>q=new LinkedList<>();
        ((LinkedList<Integer>) q).add(root);
        while (q.size()>0)
        {
            int cur_node=q.poll();
            if(vis[cur_node])continue;
            System.out.println(cur_node);
            vis[cur_node]=true;
            for(int i=0;i<graph[cur_node].size();i++)
            {
                if(!vis[graph[cur_node].get(i)])
                {
                    q.add(graph[cur_node].get(i));
                }
            }
        }
    }

    //  MAIN FUNCTION TO CHECK CYCLE

    public boolean isCyclic()
    {
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(isCyclic(i,vis,-1))return true;
            }
        }
        return false;
    }

    //HELPER FUNCTION TO CHECK CYCLE
    
    public boolean isCyclic(int node,boolean vis[],int parent)
    {
        vis[node]=true;
        for(int i=0;i<graph[node].size();i++)
        {
            if(vis[graph[node].get(i)]&&graph[node].get(i)!=parent){
                return true;}
            if(!vis[graph[node].get(i)]){
                if(isCyclic(graph[node].get(i),vis,node))return true;
            }
        }
        return false;
    }



}
