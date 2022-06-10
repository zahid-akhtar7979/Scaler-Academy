package com.scaler.assignment.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.

Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.

Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.

NOTE: All cities can be visited from any city.



Problem Constraints
1 <= A <= 105

1 <= B[i][0], B[i][1] <= N



Input Format
First argument is an integer A denoting the number of cities, N.

Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .



Output Format
Return an integer denoting the maximum number of roads king can construct.



Example Input
Input 1:

 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]
Input 2:

 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]


Example Output
Output 1:

 0
Output 2:

 2


Example Explanation
Explanation 1:

 We can't construct any new roads such that the country remains bipartite.
Explanation 2:

 We can add two roads between cities (4, 2) and (4, 5).
 */

public class ConstructRoads {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph  = new ArrayList<>();

        ArrayList<Integer>vertex1 = new ArrayList<>();
        vertex1.add(1);
        vertex1.add(3);

        ArrayList<Integer>vertex2 = new ArrayList<>();
        vertex2.add(1);
        vertex2.add(4);

        ArrayList<Integer>vertex3 = new ArrayList<>();
        vertex3.add(3);
        vertex3.add(2);

        ArrayList<Integer>vertex4 = new ArrayList<>();
        vertex4.add(3);
        vertex4.add(5);


        graph.add(vertex1);
        graph.add(vertex2);
        graph.add(vertex3);
        graph.add(vertex4);

        ArrayList<ArrayList<Integer>> graph2  = new ArrayList<>();
        ArrayList<Integer>vertex8 = new ArrayList<>();
        vertex8.add(2);
        vertex8.add(1);
        graph2.add(vertex8);

        System.out.println(solve(2, graph2));


    }
    public static int solve(int n, ArrayList<ArrayList<Integer>> graph) {

        int[] color = new int[n+1];
        Arrays.fill(color,-1);

        long countRed = 0;
        ArrayList<ArrayList<Integer>> adjacencyList =  getAdjacencyList( n, graph);
        System.out.println(adjacencyList);

        boolean isBipartite = checkBipartite(adjacencyList, n,color);

        if(isBipartite){
            for(int colorElement : color){
                if(colorElement == 1){
                    countRed++;
                }
            }
        }
        long countBlack = n-countRed;

        System.out.println(countRed);
        System.out.println(Arrays.toString(color));
        return (int) (countBlack*countRed % 1000000007 - graph.size() % 1000000007);

    }


    public static boolean dfsCheck(ArrayList < ArrayList < Integer >> graph, int node, int color[]){


        for(int adjNode : graph.get(node)){

            if(color[adjNode] == -1){
                color[adjNode] = 1-color[node];
                if(!dfsCheck(graph, adjNode, color)){
                    return false;
                }
            }
            else if(color[adjNode] == color[node]){
                return false;
            }
        }

        return true;
    }

    public static boolean checkBipartite(ArrayList < ArrayList < Integer >> graph, int n,int color[]) {

        for (int i =1; i<=n ;i++){
            if(color[i]== -1){
                color[i] = 1;
                if(!dfsCheck(graph, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    public static ArrayList<ArrayList<Integer>> getAdjacencyList(int n, ArrayList<ArrayList<Integer>> graph) {

        ArrayList<ArrayList<Integer>>adjList = new ArrayList<>();
        for(int i = 0 ;i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(ArrayList<Integer> vertices : graph){
            adjList.get(vertices.get(0)).add(vertices.get(1));
            adjList.get(vertices.get(1)).add(vertices.get(0));

        }

        return adjList;
    }
}

/*
As we know, the tree is itself bipartite.

Run a Depth First search over the given tree and partition it into two sets.

We can’t add an edge between any 2 nodes in the same set and we can add an edge between every 2 nodes in different sets, so let the number of nodes in the left set be x and the number of nodes in the right set be y.

The maximum number of edges that can exist is x * y, but N - 1 edges already exist so the maximum number of edges to be added is x * y - (N - 1).
 */

/*
public class Solution {
    static int maxn = 100009;
    static long[] col = new long[2];
    static long mod = 1000000007;
    static ArrayList < ArrayList < Integer > > adj;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList < Integer > ());
        }
        col[0] = 0;
        col[1] = 0;
    }
    public int solve(int A, int[][] B) {
        graph();
        for (int[] edge: B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(1, 0, 0);
        long ans = col[0] * col[1];
        ans -= A - 1;
        ans %= mod;
        return (int) ans;
    }
    public static void dfs(int u, int pnode, int c) {
        col[c]++;
        for (int v: adj.get(u)) {
            if (v != pnode) {
                dfs(v, u, 1 - c);
            }
        }
    }
}
 */
