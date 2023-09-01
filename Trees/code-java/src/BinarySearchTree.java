package com.vasu;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;

            if (val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        TreeNode newNode = new TreeNode(val);

        if (val < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }

    // Method to delete a node from the BST
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1: Node to be deleted has no child or only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node to be deleted has two children
            // Find the inorder successor (smallest node in the right subtree)
            TreeNode minNode = findMinNode(root.right);

            // Copy the inorder successor's data to this node
            root.val = minNode.val;

            // Delete the inorder successor
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    // Method to find the smallest node in a subtree
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}