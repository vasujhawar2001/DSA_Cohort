package com.vasu;

public class CreateBinaryTree {
   TreeNode root;

    public CreateBinaryTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRecursive(root, key);
    }

    public TreeNode insertRecursive(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.val)
            root.left = insertRecursive(root.left, key);
        else if (key > root.val)
            root.right = insertRecursive(root.right, key);

        return root;
    }

    void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        CreateBinaryTree tree = new CreateBinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorderTraversal(tree.root);
        System.out.println("Tree root -> " + tree.root.val);
    }
}
