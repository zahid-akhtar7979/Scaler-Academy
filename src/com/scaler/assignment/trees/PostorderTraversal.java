package com.scaler.assignment.trees;

import java.util.ArrayList;

public class PostorderTraversal {
	
	public static void main(String[] args) {
		
	}
	
	public static ArrayList<Integer> postorderTraversal(TreeNode A) {

		ArrayList<Integer>postorder = new ArrayList<>();
		postorder(A,postorder);
		return postorder;
    }

	public static void postorder(TreeNode A,ArrayList<Integer>postorder) {

		if(A == null){
			return ;
		}
		postorder(A.left,postorder);
		postorder(A.right,postorder);
		postorder.add(A.val);
	}

}
