package com.vasu;

public class BinaryTreeArray {
    private int[] tree;
    private int size;

    public BinaryTreeArray(int size) {
        this.size = size;
        this.tree = new int[size];
    }

    public void setRoot(int value) {
        tree[0] = value;
    }

    public void setLeft(int index, int value) {
        int leftIndex = 2 * index + 1;
        if (leftIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        tree[leftIndex] = value;
    }

    public void setRight(int index, int value) {
        int rightIndex = 2 * index + 2;
        if (rightIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        tree[rightIndex] = value;
    }

    public int getRoot() {
        return tree[0];
    }

    public int getLeft(int index) {
        int leftIndex = 2 * index + 1;
        if (leftIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        return tree[leftIndex];
    }

    public int getRight(int index) {
        int rightIndex = 2 * index + 2;
        if (rightIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        return tree[rightIndex];
    }
}
