package com.scaler.assignment.dsa;

import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.
 */

public class RainWaterTrapped {

    public static void main(String[] args) {
        System.out.println(trap(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));

    }
    public static int trap(final List<Integer> A) {

        int start = 0;
        int end = A.size()-1;

        int leftMax = A.get(start);
        int rightMax = A.get(end);

        int waterTrapped = 0;//0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1


        while (start < end){

            if (A.get(start) <= A.get(end)){
                if(A.get(start) > leftMax){
                    leftMax = A.get(start);
                }
                else {
                    waterTrapped = waterTrapped + leftMax-A.get(start);
                }

                start++;
            }
            else{
                if (A.get(end) > rightMax){
                    rightMax = A.get(end);
                }
                else {
                    waterTrapped = waterTrapped + rightMax- A.get(end);
                }
                end--;
            }

        }

        return waterTrapped;
    }
}
/*
Solution Approach
Instead of calculating area by height*width, we can think it in a cumulative way.
In other words, we can sum the water amount of each bin(width=1). Search from left to right and maintain a max height of
left and right separately, which is like a one-side wall of a partial container. Fix the higher one and flow water
from the lower part. For example, if the current height of the left is lower, we fill water in the left bin. Until the left meets right,
we filled the whole container.
 */

/*
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {

        int n=A.length;
        int left = 0; int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;

        while(left <= right){

            // When height of left side is lower, calculate height of water trapped in left bin else calculate for right bin
            if(A[left] <= A[right]){
                if(A[left] >= maxleft) maxleft = A[left];
                else res += maxleft-A[left];
                left++;
            }
            else{
                if(A[right] >= maxright) maxright = A[right];
                else res += maxright - A[right];
                right--;
            }
        }
        return res;
    }
}

 */