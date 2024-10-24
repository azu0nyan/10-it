 
package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class __GraphUTILS {
    ///SEARCHS
    public static void dfs(ArrayList<Integer> [] g, int v){
        boolean visited [] = new boolean[g.length];
        visited[v] = true;
        ArrayList<Integer> toVisit = new ArrayList<>();
        toVisit.add(v);
        while (!toVisit.isEmpty()){
            int current = toVisit.remove(toVisit.size() - 1);
            for (Integer integer : g[current]) {
                if(!visited[integer]){
                    visited[integer] = true;
                    toVisit.add(integer);
                }
            }
        }

    }
    ////CHECKS
    public static boolean checkTournament(int [][] g){
        for (int i = 0; i < g.length; i++) {
            for (int j = i + 1; j < g.length; j++) {
                if((g[i][j] ^ g[j][i] )== 0)return false;
            }
        }
        return true;
    }

    public static boolean checkFull(int [][] g){
        for (int i = 0; i < g.length; i++) {
            for (int j = i + 1; j < g.length; j++) {
                if(g[i][j] == 0 && g[j][i] == 0)return false;
            }
        }
        return true;
    }
    static boolean checkIn(int g[][], int v) {
        for (int i = 0; i < g.length; i++) {
            if (g[v][i] > 0) return false;
        }
        return true;
    }

    static boolean checkOut(int g[][], int v) {
        for (int i = 0; i < g.length; i++) {
            if (g[i][v] > 0) return false;
        }
        return true;
    }

    /////
    static final int v1 = 0;
    static final int v2 = 1;
    static final int weight = 2;
    public static int getMinimumSpanningTreeWeight(int nodes, int[][] edges) {//slow O(e * v)
        if (nodes <= 1) return 0;
        Arrays.sort(edges, (x, y) -> Integer.compare(x[weight], y[weight]));
        int[] graphsID = new int[nodes];
        for (int i = 0; i < graphsID.length; i++) {
            graphsID[i] = i;
        }
        int edgesInGraph = 0;
        int sumWeight = 0;
        for (int[] edge : edges) {
            if (graphsID[edge[v1]] != graphsID[edge[v2]]) {//union
                edgesInGraph++;//add edge to graph
                sumWeight += edge[weight];
                if (edgesInGraph == nodes - 1) {
                    return sumWeight;
                }
                int newID = graphsID[edge[v1]];
                int oldID = graphsID[edge[v2]];
                for (int i = 0; i < graphsID.length; i++) {
                    if (graphsID[i] == oldID) {
                        graphsID[i] = newID;
                    }
                }
            }
        }

        return 0;
    }
    public static void floyd(int [][] g){
        int vCount = g.length;
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                for (int k = 0; k < vCount; k++) {
                    if (k == i || k == j || j == i) continue;
                    g[j][k] = Math.min(g[j][k], g[j][i] + g[i][k]);

                }
            }
        }
    }




    //reads////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    public static ArrayList<Integer>[]readMatrixToAdjacencyList(int n){
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> res [] = new ArrayList[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(s.nextInt() > 0) {
                    res[i].add(j);
                }
            }
        }
        return  res;
    }

    public static int[][]readMatrixToMatrix(int n){
        Scanner s = new Scanner(System.in);
        int res [][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = s.nextInt();
            }
        }
        return  res;
    }
    public static int [][]readAdjacencyListToMatrix(int nodes){
        Scanner s = new Scanner(System.in);
        int res [][]= new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            int edges = s.nextInt();
            for (int j = 0; j < edges; j++) {
                res[i][s.nextInt()] = 1;//s.nextInt() -1 for no 0 v
            }
        }
        return res;
    }

    public static ArrayList<int[]> readMatrixToEdgeList(int n){
        Scanner s = new Scanner(System.in);
        ArrayList<int []> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(s.nextInt() == 1) {
                    edges.add(new int[]{i, j});
                }
            }
        }
        return  edges;
    }

    public ArrayList<Integer> [] readEdgeListToAdjacencyList(int nodes, int edges){
        Scanner s = new Scanner(System.in);

        ArrayList<Integer> res []= new ArrayList [nodes];
        for (int i = 0; i < nodes; i++) {
            res[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int n1 =s.nextInt();
            int n2 =s.nextInt();
            res[n1].add(n2);// -1 -1 for 1 indexes
        }
        for (int i = 0; i < nodes; i++) {
            Collections.sort(res[i]);
        }
        return res;
    }

    public int [][] readEdgesList(){
        Scanner s = new Scanner(System.in);
        int vertex = s.nextInt();
        int edgesC = s.nextInt();
        int edges [][] = new int[edgesC][2];
        for (int i = 0; i < edgesC; i++) {
            edges[i][0] = s.nextInt();
            edges[i][1] = s.nextInt();
        }
        return edges;
    }
    public  static int [][] readEdgesListToMatrix(){
        Scanner s = new Scanner(System.in);
        int vertex = s.nextInt();
        int edgesC = s.nextInt();
        int edges [][] = new int[vertex][vertex];
        for (int i = 0; i < edgesC; i++) {
            edges[s.nextInt() - 1][s.nextInt() - 1] = 1;
        }
        return edges;
    }
}
