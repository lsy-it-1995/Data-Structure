package graph;


import java.io.*;
import java.util.*;

public class dfs {

    private LinkedList<Integer> adj[];
    private boolean visited[];
    private int V;
    @SuppressWarnings("unchecked") dfs(int v){
        this.V = v;
        this.adj = new LinkedList[v];
        this.visited = new boolean[v];

        for(int i = 0; i < v; i++){
            this.adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int vertex, int adj){
        this.adj[vertex].add(adj);
    }

//    public void printTree(){
//        for(int i = 0; i < adj.length; i++){
//            System.out.print(i +" ");
//            for(int j = 0; j < adj[i].size(); j++){
//                System.out.print(adj[j]+" ");
//            }
//            System.out.println();
//        }
//    }

    public void stackDFS(int v){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        System.out.print(v + " ");
//        visited[v] = true;
        while(!stack.isEmpty()){
            int peek = stack.peek();
            stack.pop();
            for(int i = 0; i < adj[peek].size(); i++){
                int val = adj[peek].get(i);
                if(visited[val] == false){
                    stack.push(val);
                    visited[val] = true;
                    System.out.print(val + " ");
                }
            }
        }
        System.out.println();
    }
    public void nonStackDFS(int v){
        this.visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> ite = adj[v].listIterator();
        while(ite.hasNext()){
            int adj = ite.next();
            if(!this.visited[adj]){
                nonStackDFS(adj);
            }
        }
    }
}