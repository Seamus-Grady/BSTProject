package com.BSTProject.Node;

public class BSTNode {
    private BSTNode left;
    private BSTNode right;
    private BSTNode parent;
    private int value;

    public BSTNode(int value) {
        this(null, null, null, value);
    }

    public BSTNode(BSTNode left, BSTNode right, BSTNode parent, int value) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }
    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getParent() {
        return parent;
    }
    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
