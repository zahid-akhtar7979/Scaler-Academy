package com.scaler.assignment.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestElement {

    public static void main(String[] args) {

        System.out.println(kthsmallest(Arrays.asList( 48, 77, 77, 6, 95, 19, 2, 97, 29, 27, 9),8));
    }

    public static int kthsmallest(final List<Integer> input, int B) {

        List<Integer>A = new ArrayList<>(input);
        int len = input.size()-1;
        for (int i = 0 ;i < B; i++){
            int min = A.get(0);
            int index = 0;
            for(int j = 0; j<=len-i;j++){
                if(min > A.get(j)){
                    min = A.get(j);
                    index = j;
                }
            }
            System.out.println("minimum is "+min);
            Collections.swap(A,index,len-i);

        }

        System.out.println(A);

        return A.get(input.size()-B);
    }
}
