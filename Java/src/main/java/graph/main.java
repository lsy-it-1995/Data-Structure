package graph;

import java.util.Random;

public class main {
    public static void main(String[] args){
//        new main().bfsBuildTree(4);
//        new main().buildPrim();
        new main().dfsBuildTree(5);
    }
    public void bfsBuildTree(int num){
        bfs tree = new bfs(num);

        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
//        tree.printTree();
        tree.go(2);
    }

    public void dfsBuildTree(int num){
        dfs tree = new dfs(num);
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
        tree.addEdge(new Random().nextInt(4), new Random().nextInt(4));
//        tree.printTree();

        tree.nonStackDFS(3);
        System.out.println();
        System.out.println();

        tree.stackDFS(3);
    }
    public void buildPrim(){
        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        prim p = new prim();
        p.primMST(graph,graph.length);

    }

}
