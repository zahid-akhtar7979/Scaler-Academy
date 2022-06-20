package com.scaler.assignment.dsa;

import java.util.ArrayList;


/*
Problem Description
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
0 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
 */
public class MergeIntervals {
    public static void main(String[] args) {

        ArrayList<Interval>input = new ArrayList<>();
        input.add(new Interval(1,2));
        input.add(new Interval(3,6));

        System.out.println(insert(input,new Interval(8,10)));

    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        int minValue = newInterval.start;
        int maxValue = newInterval.end;

        ArrayList<Interval>resultList = new ArrayList<>();

        for(Interval interval :intervals){

            if(isInsideInterval(interval, newInterval)){

                minValue = Math.min(interval.start,newInterval.start);
                maxValue = Math.max(interval.end,newInterval.end);
                newInterval.start = minValue;
                newInterval.end = maxValue;
            }
            else {
                resultList.add(interval);
            }
        }

        int i=0;
        while(i < resultList.size() && newInterval.start > resultList.get(i).start){
            i++;
        }

        if(i == resultList.size()){
            resultList.add(newInterval);
        }
        else {
            resultList.add(i,newInterval);
        }

        return  resultList;

    }

    public static  boolean isInsideInterval(Interval interval, Interval newInterval){

        if(newInterval.start >= interval.start && newInterval.start <= interval.end){
            return true;
        }

        else if(newInterval.end >= interval.start && newInterval.end <= interval.end){
            return true;
        }

        else if(newInterval.start <= interval.start && newInterval.end >= interval.end){
            return true;
        }
        return false;

    }
}
// Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
/*
Solution Approach
Have you covered the following corner cases :

1) Size of interval array as 0.

2) newInterval being an interval preceding all intervals in the array.

    Given interval (3,6),(8,10), insert and merge (1,2)
3) newInterval being an interval succeeding all intervals in the array.

    Given interval (1,2), (3,6), insert and merge (8,10)
4) newInterval not overlapping with any interval and falling in between 2 intervals in the array.

    Given interval (1,2), (8,10) insert and merge (3,6)
5) newInterval covering all given intervals.

    Given interval (3, 5), (7, 9) insert and merge (1, 10)
 */

/*
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;
        int startIndex = endIndex = -1;
        for (Interval in : intervals) {
            if (start >= in.start && start <= in.end)
                startIndex = i;
            if (end >= in.start && end <= in.end)
                endIndex = i;
            i++;
        }
        // endpoints of new interval doesn't lie inside any other interval
        if (startIndex == -1 && endIndex == -1) {
            startIndex = 0;
            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }
            endIndex = intervals.size() - 1;
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }
            // Intervals between startIndex and endIndex lies completely inside new interval
            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }
            intervals.add(startIndex, newInterval);
            return intervals;
        }
        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }
        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }
        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);
        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;
        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }
        return intervals;
    }
}
 */