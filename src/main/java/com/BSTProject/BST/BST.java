package com.BSTProject.BST;

import com.BSTProject.Node.BSTNode;

public class BST {
    private BSTNode root;
    private BSTRecursive bstRecursive;
    
    public BST() {
        this.root = null;
        this.bstRecursive = new BSTRecursive();
    }

    public BSTNode getRoot() {
        return this.root;
    }

    public void insert(int value) {
        if(this.root == null) {
            this.root = new BSTNode(value);
            return;
        }

        this.bstRecursive.insertRecursive(value, root);
    }

    public BSTNode delete(int value) {
        return this.bstRecursive.deleteRecursive(value, root, null);
    }

    public BSTNode search(int value) {
        return this.bstRecursive.searchRecursive(value, root);
    }

    public int count() {
        return this.bstRecursive.countRecursive(root);
    }
}
