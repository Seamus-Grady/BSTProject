package com.BSTProject.BST;

public class BST {
    private Node root;
    private BSTRecursive bstRecursive;
    
    public BST() {
        this.root = null;
        this.bstRecursive = new BSTRecursive();
    }

    public void insert(int value) {
        if(this.root == null) {
            this.root = new Node(value);
            return;
        }

        this.bstRecursive.insertRecursive(value, root);
    }

    public Node delete(int value) {
        return this.bstRecursive.deleteRecursive(value, root, null);
    }

    public Node search(int value) {
        return this.bstRecursive.searchRecursive(value, root);
    }

    public int count() {
        return this.bstRecursive.countRecursive(root);
    }
}
