package com.scaler.assignment.stack;

import java.util.Stack;


/*
 * Given a string A representing an absolute path for a file (Unix-style).

Return the string A after simplifying the absolute path.

Note:

In Unix-style file system:

A period '.' refers to the current directory.
A double period '..' refers to the directory up a level.
Any multiple consecutive slashes '//' are treated as a single slash '/'.
In Simplified Absolute path:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path doesn't end with trailing slashes '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Path will not have whitespace characters.

Input Format

The only argument given is string A.
Output Format

Return a string denoting the simplified absolute path for a file (Unix-style).
For Example

Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
 */

public class SimplifyDirectoryPath {
	
	public static void main(String[] args) {
		
		System.out.println(simplifyPath("/../"));
		
	}
	
	 public static String simplifyPath(String A) {
		 
		 Stack<String>pathStack = new Stack<>();
		 Stack<String>pathStackReverse = new Stack<>();
		 
		 for(int i=0;i<A.length();i++) {
			 
			 while(i < A.length() && A.charAt(i) == '/') {
				 i++;
			 }
			 
			 StringBuilder strb = new StringBuilder();
			 while(i < A.length() && A.charAt(i) != '/') {
				 
				 strb.append(A.charAt(i));
				 i++;
			 }
			 if(!strb.toString().isEmpty()) {
				 
				 if((strb.toString().equals("."))){
					 continue;
				 }
				 
				 else if(strb.toString().equals("..")) {
					 if(!pathStack.isEmpty()) {
						 pathStack.pop();
					 }
				 }
				 else {
					 pathStack.push(strb.toString());
				 }
			 }
		 }
		 
		 System.out.println(pathStack);
		 
		 if(pathStack.isEmpty()) {
			 return "/";
		 }
		 
		 while(!pathStack.isEmpty()) {
			 
			 String str = pathStack.pop();
			 pathStackReverse.push(str);
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 
		 while(!pathStackReverse.isEmpty()) {
			 
			 String str = pathStackReverse.pop();
			 sb.append("/").append(str);
		 }
		 
		 return sb.toString();
		 
	 }

}

/*
 * More of a simulation problem.
Break the string along ‘/’ and process the substrings in order one by one. ‘..’ indicates popping an entry unless there is nothing to pop.
 */

/*
 * public class Solution {
	public String simplifyPath(String A) {
	    Stack<String> stack = new Stack<>();
	    int start, end;
	    int n = A.length();
	    String str;
	    
	    for (int i = 0; i < n;) {
	        
	       while (i < n && A.charAt(i) == '/')
	           i++;
	            
	       start = i;
	           
	       if (i >= n)
	           break;
	            
	       while (i < n && A.charAt(i) != '/') {
	           i++;
	       }
	       
	       str = A.substring(start, i);
	            
	       if (str.equalsIgnoreCase("..")) {
	            if (!stack.isEmpty())
	               stack.pop();
	       } else if (!str.equalsIgnoreCase(".")) {
	           stack.push(str);
	       }
	            
	    }
	    
	    String res = "";
	    
	    if (stack.isEmpty())
	        res = "/";
	    
	    while (!stack.isEmpty()) {
	        res = "/" + stack.pop() + res;
	    }
	    
	    return res;
	}
}

 */





