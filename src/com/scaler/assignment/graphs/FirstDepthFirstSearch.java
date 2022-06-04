package com.scaler.assignment.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.



Problem Constraints
1 <= N <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.

 */
public class FirstDepthFirstSearch {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 3, 3, 4, 6, 5, 3, 3  ));
		int B = 10;
		int C =3;
		
		System.out.println(solve(A, B, C));
		
	}
	
	public static int solve(ArrayList<Integer> A, final int B, final int C) {
		
		boolean visited[] = new boolean[A.size() + 1];
		Arrays.fill(visited, false);
		
		ArrayList<ArrayList<Integer>>graph= getAdjacencyList(A);
		System.out.println(graph);
		
		if(isReachable(graph , B,  C, visited)) {
			return 1;
		}
		return 0;
    }
	
	
	public static boolean isReachable(ArrayList<ArrayList<Integer>>graph , final int B, final int C,boolean visited[]) {
		
		visited[C] = true;
		if(B == C) {
			return true;   
		}
		
		ArrayList<Integer>adjNodes= graph.get(C);
		
		for(int adjNode :adjNodes ) {
			if(!visited[adjNode]) {
				
				if(isReachable(graph ,B,adjNode, visited)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static ArrayList<ArrayList<Integer>> getAdjacencyList(ArrayList<Integer> A) {
		
		ArrayList<ArrayList<Integer>>adjList = new ArrayList<>();
		for(int i = 0 ;i <= A.size(); i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i< A.size() ; i++) {
			adjList.get(A.get(i)).add(i+1);
		}
		return adjList;
	}
	

}


/*
 * Solution Approach
Since you have to start from town number 1 , start your traversal from 1 (root) and use depth first search to reach the second town i.e. y.
Let the query be 6 3, then first search 3 starting from 1.
Now apply depth first search considering root as y ( 3 in this case ) ( move away from 1 ) and search whether x ( i.e. 6 ) is one of its successor. If yes return 1 else return 0 .

OR

Consider parent of i as a[i] and start depth first search from ““y”” to search for x.
 */


/*
 * 
 * public class Solution {
  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
   * 
  static int maxn = 100009;
  static int[] vis = new int[maxn];
  static ArrayList < ArrayList < Integer > > adj;
  public static void graph() {
    adj = new ArrayList < ArrayList < Integer > > (maxn);
    for (int i = 0; i < maxn; i++) {
      vis[i] = 0;
      adj.add(new ArrayList < Integer > ());
    }
  }
  public int solve(int[] A, final int B, final int C) {
    graph();
    int n = A.length;
    for (int i = 1; i < n; i++) {
      adj.get(A[i]).add(i + 1);
    }
    if (dfs(C, B) == true)
      return 1;
    return 0;
  }
  public static boolean dfs(int s, int x) {
    if (s == x)
      return true;
    vis[s] = 1;
    int i, j, k = adj.get(s).size();
    for (i = 0; i < k; i++) {
      j = adj.get(s).get(i);
      if (vis[j] == 0 && dfs(j, x) == true)
        return true;
    }
    return false;
  }
}
 */





