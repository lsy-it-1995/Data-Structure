package graph;

import java.util.Arrays;

public class prim {
    private int vertices;

    public int minKey(int[] key, Boolean[] set){
        int min_index = -1,
                min_value = Integer.MAX_VALUE;
        for(int i = 0; i < this.vertices; i++){
            if(key[i] < min_value && set[i] == false){ //update key array
                min_index = i;
                min_value = key[i];
            }
        }
        return min_index;
    }
    public void primMST(int[][] graph, int v){
        this.vertices = v;
        int[] key = new int[v];
        int[] parent = new int[v];
        Boolean[] set = new Boolean[v];
        Arrays.fill(set, false);
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;


        for(int i = 0; i < this.vertices - 1; i++){
            int spot = minKey(key, set);
            set[spot] = true;
            for(int j = 0; j < this.vertices; j++){
                if(set[j] == false && key[j] > graph[spot][j] && graph[spot][j] != 0){
                    key[j] = graph[spot][j];
                    parent[j] = spot;
                }
            }
        }
        print_weight(key, parent);
    }
    public void print_weight(int[] arr, int[] parent){
        for(int i = 0; i < arr.length; i++){
            System.out.println(parent[i] + " - " + i + ". weight: " + arr[i]);
        }
    }}
