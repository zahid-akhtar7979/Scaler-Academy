package com.scaler.assignment.intermediate;

import java.util.*;

/*
Problem Description
Given an array A of N strings, return all groups of strings that are anagrams.

Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.

NOTE: Anagram is a word, phrase, or name formed by rearranging the letters, such as 'spar', formed from 'rasp'.



Problem Constraints
1 <= N <= 104

1 <= |A[i]| <= 104

Each string consists only of lowercase characters.

The sum of the length of all the strings doesn't exceed 107



Input Format
The first and only argument is an integer array A.



Output Format
Return a two-dimensional array where each row describes a group.

Note:

Ordering of the result :
You should not change the relative ordering of the strings within the group suppose within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.



Example Input
Input 1:

 A = [cat, dog, god, tca]
Input 2:

 A = [rat, tar, art]


Example Output
Output 1:

 [ [1, 4],
   [2, 3] ]
Output 2:

 [ [1, 2, 3] ]


Example Explanation
Explanation 1:

 "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god" are another set of anagrams which correspond to index 2 and 3.
 The indices are 1 based ( the first element has index 1 instead of index 0).
Explanation 2:

 All three strings are anagrams.
 */

public class Anagrams {

    public static void main(String[] args) {

        List<String>inputList = Arrays.asList("cat", "dog", "god", "tca");

        System.out.println(anagrams(inputList));

    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

        Map<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>>resultList = new ArrayList<>();

        for(int i = 0;i<A.size() ;i++){

            String temp = sortString(A.get(i));
            if(map.containsKey(temp)){
                map.get(temp).add(i+1);
            }
            else{
                ArrayList<Integer>list = new ArrayList<>();
                list.add(i+1);
                map.put(temp,list);
            }
        }

        for(String key : map.keySet()){
            resultList.add(map.get(key));
        }

        return resultList;
    }


    public static String sortString(String str){

        int[] charArray = new int[26];

        for(Character ch : str.toCharArray() ){
            charArray[ch - 97]++;
        }

        StringBuilder sb  = new StringBuilder();
        for(int i = 0; i< 26 ;i++){
            int j = 0;
            while(j < charArray[i]){
                sb.append((char) (97 + i));
                j++;
            }
        }
        return sb.toString();
    }
}
/*
Solution Approach
Anagrams will map to the same string if the characters in the string are sorted.
We can maintain a hashmap with the key being the sorted string and the value being the list of strings ( which have the sorted characters as keys).
 */
/*
public class Solution {
    public ArrayList < ArrayList < Integer >> anagrams(final List < String > A) {
        ArrayList < ArrayList < Integer >> res = new ArrayList < > ();
        HashMap < String, ArrayList < Integer >> hashMap = new HashMap < > ();
        int i = 1;
        for (String str: A) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            if (hashMap.containsKey(sorted)) {
                ArrayList < Integer > list = hashMap.get(sorted);
                list.add(i);
            } else {
                ArrayList < Integer > list = new ArrayList < > ();
                list.add(i);
                hashMap.put(sorted, list);
            }
            i++;
        }
        for (Map.Entry < String, ArrayList < Integer >> entrySet: hashMap.entrySet()) {
            res.add(entrySet.getValue());
        }
        return res;
    }
 */