package com.scaler.assignment.trees;

// Definition for binary tree

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		
		TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
  
        System.out.println("Height of tree is : " +
        		heightOfTree(tree.right));

	}

	public int solve(TreeNode A) {

		return -1;
	}
	
	public static int heightOfTree(TreeNode A) {
		
		if(A == null) {
			
			return -1;
		}
		
		return 1+ Math.max(heightOfTree(A.left), heightOfTree(A.right));
	}

}
