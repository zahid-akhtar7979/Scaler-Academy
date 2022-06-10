package com.scaler.assignment.graphs;

import java.util.ArrayList;
import java.util.Arrays;


/*
Problem Description

Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].



Output Format

Return 1 if cycle is present else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
Input 2:

 A = 3
 B = [  [1. 2]
        [1, 3]
     ]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1
Explanation 2:

 No cycle present in the graph so we will return 0.
 */


public class CycleInUndirectedGraph {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph  = new ArrayList<>();

        ArrayList<Integer>vertex1 = new ArrayList<>();
        vertex1.add(1);
        vertex1.add(2);

        ArrayList<Integer>vertex2 = new ArrayList<>();
        vertex2.add(1);
        vertex2.add(3);

        ArrayList<Integer>vertex3 = new ArrayList<>();
        vertex3.add(2);
        vertex3.add(3);

        ArrayList<Integer>vertex4 = new ArrayList<>();
        vertex4.add(1);
        vertex4.add(4);

        ArrayList<Integer>vertex5 = new ArrayList<>();
        vertex5.add(4);
        vertex5.add(5);



        graph.add(vertex1);
        graph.add(vertex2);
        graph.add(vertex3);
        graph.add(vertex4);
        graph.add(vertex5);

        System.out.println(solve(3,graph));

    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {

        boolean[] visited = new boolean[A+1];
        Arrays.fill(visited,false);

        ArrayList<ArrayList<Integer>> adjacencyList = getAdjacencyList(A,  B);
        for (int i =1;i<=A; i++){

            if (!visited[i]){
                if(checkforCycle(i , -1, visited, adjacencyList)){
                    return 1;
                }
            }
        }
        return 0;

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

    public static boolean checkforCycle(int node , int parentNode, boolean[] visited, ArrayList<ArrayList<Integer>>adjacencyList){

        visited[node]  = true;
        for (int adjacentNode : adjacencyList.get(node)){
            if(!visited[adjacentNode]){
                if(checkforCycle(adjacentNode , node, visited, adjacencyList)){
                    return  true;
                }
            }

            else {
                if (adjacentNode != parentNode){
                    return true;
                }
            }
        }
        return false;
    }
}

/*
Solution Approach
Method 1: DFS
Like directed graphs, we can use DFS to detect cycle in an undirected graph in O(A+M) time.
We do a DFS traversal of the given graph. For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph.
If we don’t find such an adjacent for any vertex, we say that there is no cycle.
The assumption of this approach is that there are no parallel edges between any two vertices


Method 2: Union-Find
We can keep track of the subsets in a 1D array, let’s call it parent[].
For each edge, make subsets using both the vertices of the edge. If both the vertices are in the same subset, a cycle is found.
Initially, all slots of parent array are initialized to -1 (means there is only one item in every subset).
Time Complexity: O(MlogA)
 */

/*
import java.util.*;
class GFG {
    public static void main(String[] args) {


        int V = 5;

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList < > ());
        }
        // edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // adge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);


        Solution obj = new Solution();
        boolean ans = obj.isCycle(V, adj);
        if (ans == true) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");

        }
    }
}


class Solution {
    public boolean checkForCycle(int node, int parent, boolean vis[], ArrayList < ArrayList
    < Integer >> adj) {
        vis[node] = true;
        for (Integer it: adj.get(node)) {
            if (vis[it] == false) {
                if (checkForCycle(it, node, vis, adj) == true)
                    return true;
            } else if (it != parent)
                return true;
        }

        return false;
    }
    // 0-based indexing Graph
    public boolean isCycle(int V, ArrayList < ArrayList < Integer >> adj) {
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, -1, vis, adj))
                    return true;
            }
        }

        return false;
    }
}
 */
