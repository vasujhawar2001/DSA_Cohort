package com.vasu;

public class Main {

    public static void main(String[] args) {
	// write your code here

        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.insert(100);
        bst1.insert(20);
        bst1.insert(200);
        bst1.insert(105);
        bst1.insert(50);
        bst1.inorder();
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
