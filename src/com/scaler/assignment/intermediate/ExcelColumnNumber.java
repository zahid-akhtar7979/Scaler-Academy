package com.scaler.assignment.intermediate;

public class ExcelColumnNumber {
	
	public static void main(String[] args) {
		
		System.out.println(titleToNumber( "AB"));
	}
	
 public static int titleToNumber(String A) {

        int title = 0;
        for(int i =A.length()-1; i>=0 ;i--){
        	int exponents = A.length()-1 -i;
            title= (int) (title + (A.charAt(i) -'A' + 1) * Math.pow(26,exponents));
        }

        return title;
    }

}
