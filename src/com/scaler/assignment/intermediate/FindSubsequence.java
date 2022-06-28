package com.scaler.assignment.intermediate;


/*
Given two strings A and B, find if A is a subsequence of B.

Return "YES" if A is a subsequence of B, else return "NO".


Input Format

The first argument given is the string A.
The second argument given is the string B.
Output Format

Return "YES" if A is a subsequence of B, else return "NO".
Constraints

1 <= lenght(A), length(B) <= 100000
'a' <= A[i], B[i] <= 'z'
For Example

Input 1:
    A = "bit"
    B = "dfbkjijgbbiihbmmt"
Output 1:
    YES

Input 2:
    A = "apple"
    B = "appel"
Output 2:
    "NO"
 */
public class FindSubsequence {

    public String solve(String A, String B) {

        boolean isSubSequence = isSubSequence(A, B, A.length()-1, B.length()-1);
        if(isSubSequence){
            return "YES";
        }
        return "NO";
    }

    public static boolean isSubSequence(String str1, String str2,
                                        int m, int n)
    {
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequence(str1, str2, m - 1, n - 1);
        return isSubSequence(str1, str2, m, n - 1);
    }
}
/*
Solution Approach
1. Traverse both A and B from left to right. If we find a matching character, we move ahead in both strings. Otherwise, we move ahead only in B.
2. if A finishes first, return "YES"
3. Else return "NO"
 */

/*
public class Solution {
    public String solve(String A, String B) {
        int m = A.length();
        int n = B.length();
        int i=0,j=0;
        while(i<m && j<n)
        {
            if(A.charAt(i) == B.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        if(i == m)
        {
            return "YES";
        }
        return "NO";
    }
}
 */