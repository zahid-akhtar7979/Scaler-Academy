package com.scaler.assignment.intermediate;

import java.util.ArrayList;

/*
Problem Description

You are given a 2D integer matrix A having N rows and M columns.

You have to return a 2D matrix containing only even elements in every row.i.e. You have to remove all the odd elements in every row and return the resulting matrix.

NOTE: You are allowed to use extra memory.



Problem Constraints

1 <= N, M <= 1000

1 <= A[i][j] <= 109



Input Format

First and only argument is a 2D integer matrix.



Output Format

Return a 2D integer matrix.



Example Input

Input 1:

 [ [1, 2, 3, 4],
   [4, 5, 6, 7],
   [8, 9, 10, 11],
   [13, 15, 17, 19] ]
Input 2:

 [ [5, 17, 1],
   [2, 2, 6] ]


Example Output

Output 1:

 [ [2, 4],
   [4, 6],
   [8, 10],
   [] ]
Output 2:

 [ [],
   [2, 2, 6] ]


Example Explanation

Explanation 1:

 In row 1, Values 1 and 3 are removed.
 In row 2, Values 5 and 7 are removed.
 In row 3, Values 9 and 11 are removed.
 In row 4, all the values are removed.
Explanation 2:

 In row 1, all the values are removed.
 In row 2, no values are removed.
 */

public class OddsRemoved {

    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>>resultList = new ArrayList<>();

        for(ArrayList<Integer>list : A){

            ArrayList<Integer>temp = new ArrayList<>();
            for (Integer ele : list){
                if(ele % 2 == 0){
                    temp.add(ele);
                }
            }
            resultList.add(temp);
        }

        return resultList;
    }
}
/*
You can iterate through the original matrix row-wise and construct a new dynamic 2D matrix by adding only even elements.

 */
/*
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < N; i++){
            res.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N;i++){
            for (int j = 0; j < M;j++){
                if(A.get(i).get(j) % 2 == 0){
                    res.get(i).add(A.get(i).get(j));
                }
            }
        }

        return res;
    }
}

 */