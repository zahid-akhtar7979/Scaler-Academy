package com.scaler.assignment.intermediate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Description
Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.



Problem Constraints
1 <= N, length of each word <= 105

Sum of the length of all words <= 2 * 106



Input Format
The first argument is a string array A of size N.

The second argument is a string B of size 26, denoting the order.



Output Format
Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.



Example Input
Input 1:

 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:

 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The order shown in string B is: h < s < i for the given words. So return 1.
Explanation 2:

 "none" should be present after "no". Return 0.
 */

public class IsDictionary {

    public static void main(String[] args) {

        List<String>list = Arrays.asList("fine", "none", "no");

        System.out.println(solve(list,"qwertyuiopasdfghjklzxcvbnm"));

    }

    public static int solve(List<String> A, String B) {

        Map<Character,Integer> asciiCodeMap = new HashMap<>();

        int asciiCode = 0;
        for (Character ch : B.toCharArray()){
            asciiCodeMap.put(ch,asciiCode);
            asciiCode++;
        }

        for(int i = 0;i<A.size()-1;i++){

            if(compare(A.get(i),A.get(i+1),asciiCodeMap) == 1){
                continue;
            }

            return 0;
        }

        return 1;
    }

    public static int compare(String str1, String str2, Map<Character,Integer> asciiCodeMap){

        int i =0;
        int j=0;

        int l1 = str1.length();
        int l2 = str2.length();

        while(i <l1 && j < l2){

            if(asciiCodeMap.get(str1.charAt(i)) == asciiCodeMap.get(str2.charAt(j))){
                i++;
                j++;
            }

            else if(asciiCodeMap.get(str1.charAt(i)) < asciiCodeMap.get(str2.charAt(j))){
               return 1;
            }

            else{
                return 0;
            }
        }

        if(l1 > l2) {
            return 0;
        }
        return 1;

    }
}

/*
Solution Approach
Let’s check whether all adjacent words a and b have a <= b.

To check whether a <= b for two adjacent words, a and b, we can find their first difference.
For example, “applying” and “apples” have the first difference of y and e.
After, we compare these characters to the index in order.

Care must be taken to deal with the blank character effectively.
If, for example, we are comparing “app” to “apply”, the first difference is between (null) and “l”.
 */

/*
public int solve(ArrayList<String> A, String B) {
        int id[] = new int[26];
        for(int i = 0; i < B.length(); ++i){
            id[B.charAt(i)-'a'] = i;
        }
        for(int i = 0; i+1 < A.size(); ++i){
            String x = A.get(i);
            String y = A.get(i+1);
            int n = Math.min(x.length(), y.length());
            int fl = 0;
            for(int j = 0; j < n; ++j){
                int c1 = x.charAt(j)-'a';
                int c2 = y.charAt(j)-'a';
                if(c1 == c2){
                    continue;
                }
                if(id[c1] < id[c2]){
                    fl = 1;
                    break;
                }
                return 0;
            }
            if(fl == 0 && x.length() > y.length()){
                return 0;
            }
        }
        return 1;
    }
}
 */