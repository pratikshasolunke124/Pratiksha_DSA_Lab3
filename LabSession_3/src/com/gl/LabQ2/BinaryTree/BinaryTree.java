package com.gl.LabQ2.BinaryTree;

import java.util.*;

class TreeNode {
	int data;
	TreeNode left, right;

	TreeNode(int data) {
		this.data = data;
		left = right = null;
	}

//adding data to B.S Tree
	public TreeNode insertData(int data, TreeNode root) {
		if (root == null) {
			return new TreeNode(data);
		}
		if (data < root.data) {
			root.left = insertData(data, root.left);
		} else if (data > root.data) {
			root.right = insertData(data, root.right);
		} else {
			System.out.println("Given data is already present in Binary Search Tree");
		}
		return root;
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		root.insertData(20, root);
		root.insertData(60, root);
		root.insertData(10, root);
		root.insertData(30, root);
		root.insertData(50, root);
		root.insertData(70, root);
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter sum to find adding pair from mentioned Binary Tree");
			int sum = sc.nextInt();
			Set<Integer> data = new HashSet<Integer>();
			if (!findSumPair(root, sum, data)) {
				System.out.println("Pair does not exixts for given sum");
			}
		}
	}

	private static boolean findSumPair(TreeNode root, int sum, Set<Integer> data) {
		if (root == null) {
			return false;
		}
		boolean found = false;
		// left
		found = findSumPair(root.left, sum, data);
		if (found) {
			return true;
		}
		// root
		int remainder = sum - root.data;
		if (data.contains(remainder)) {
			System.out.println("The pair (" + root.data + " , " + remainder + ") can form the given sum");
			return true;
		} else {
			data.add(root.data);
		}
		// right
		found = findSumPair(root.right, sum, data);
		if (found) {
			return true;
		}
		return false;
	}
}
