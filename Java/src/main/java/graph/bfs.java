package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class bfs {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    @SuppressWarnings("unchecked") bfs(int v){
        this.V = v;
        this.adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            this.adj[i] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int v, int w){
        this.adj[v].add(w);
    }
//    public void printTree(){
//        for(int i = 0; i < adj.length; i++){
//            System.out.print(i +" ");
//            for(int j = 0; j < adj[i].size(); j++){
//                System.out.print(adj[j].toString());
//            }
//            System.out.println();
//        }
//    }

    public void go(int v){
        boolean[] visited = new boolean[this.V];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;
        while(!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> it = this.adj[v].iterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }
}
