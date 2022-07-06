package com.scaler.assignment.intermediate;

import java.util.*;

/*
Problem Description

Given three prime number(A, B, C) and an integer D. Find the first(smallest) D integers which have only A, B, C or a combination of them as their prime factors.



Problem Constraints

1 <= A, B, C <= 10000

1 <= D <= 100000



Input Format

First argument is an integer A.
Second argument is an integer B.
Third argument is an integer C.
Fourth argument is an integer D.



Output Format

Return an integer array of size D, denoting the first D integers described above.

NOTE: The sequence should be sorted in ascending order



Example Input

Input 1:

 A = 2
 B = 3
 C = 5
 D = 5
Input 2:

 A = 3
 B = 2
 C = 7
 D = 3


Example Output

Output 1:

 [2, 3, 4, 5, 6]
Output 2:

 [2, 3, 4]


Example Explanation

Explanation 1:

 4 = A * A ( 2 * 2 ), 6 = A * B ( 2 * 3 )
Explanation 2:

 2 has only prime factor 2. Similary 3 has only prime factor 3. 4 = A * A ( 2 * 2 )
 */

public class SmallestSequenceWithGivenPrimes {

    public static void main(String[] args) {

        System.out.println(solve(2,3,5,5));

    }

    public static ArrayList<Integer> solve(int A, int B, int C, int D) {

        ArrayList<Integer>resultList = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = 0;
        resultList.add(1);

        while (resultList.size() <= D){

            int minValue = Math.min(A*resultList.get(a), Math.min(B*resultList.get(b),C*resultList.get(c)));
            resultList.add(minValue);
            if(A*resultList.get(a) == minValue){
                a++;
            }
            if((B*resultList.get(b) == minValue)){
                b++;
            }
            if((C*resultList.get(c) == minValue)){
                c++;
            }
        }
        resultList.remove(0);
        return resultList;
    }
}
/*
Solution Approach
The naive solution will be to check prime factorization of every natural number incrementally till k numbers are found. However, that will be too slow.

As mentioned in the previous hint, this problem can be addressed as a modified BFS / Dijkstra. We push p1, p2 and p3 to a min heap.
Every time, we repeat the following process till we find k numbers :

 - M = Pop out the min element in the min heap.
 - Add M to the final answer.
 - Push M * p1, M * p2, M * p3 to the min heap if they are not already present in the heap ( We can use a hash map to track this )
However, this is O( k * log k ).
Can we do better than this ?

It turns out we can.
We use the fact that there are only 3 possibilities of getting to a new number : Multiply by p1 or p2 or p3.

For each of p1, p2 and p3, we maintain the minimum number in our set which has not been multiplied with the corresponding prime number yet.
So, at a time we will have 3 numbers to compare.
The corresponding approach would look something like the following :


initialSet = [p1, p2, p3]
indexInFinalSet = [0, 0, 0]

for i = 1 to k
  M = get min from initialSet.
  add M to the finalAnswer if last element in finalAnswer != M
  if M corresponds to p1 ( or in other words M = initialSet[0] )
    initialSet[0] = finalAnswer[indexInFinalSet[0]] * p1
    indexInFinalSet[0] += 1
  else if M corresponds to p2 ( or in other words M = initialSet[1] )
    initialSet[1] = finalAnswer[indexInFinalSet[1]] * p1
    indexInFinalSet[1] += 1
  else
    # Similar steps for p3.
end
 */

/*
public class Solution {
    public ArrayList < Integer > solve(int p1, int p2, int p3, int k) {
        ArrayList < Integer > finalAnswer = new ArrayList < Integer > ();
        int[] nextBestNumbers = new int[3];
        int[] currIndex = new int[3];
        int[] prime = new int[3];

        nextBestNumbers[0] = prime[0] = p1;
        nextBestNumbers[1] = prime[1] = p2;
        nextBestNumbers[2] = prime[2] = p3;
        currIndex[0] = currIndex[1] = currIndex[2] = -1;
        for (int j = 1; j <= k; j++) {
            int nextNumber = Math.min(nextBestNumbers[0], Math.min(nextBestNumbers[1], nextBestNumbers[2]));
            finalAnswer.add(nextNumber);
            for (int i = 0; i < 3; i++) {
                if (nextNumber == nextBestNumbers[i]) {
                    currIndex[i]++;
                    nextBestNumbers[i] = finalAnswer.get(currIndex[i]) * prime[i];
                }
            }
        }
        return finalAnswer;
    }
}
 */