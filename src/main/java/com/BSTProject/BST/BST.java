package com.BSTProject.BST;

public class BST {
    private Node root;
    
    public BST() {
        this.root = null;
    }

    public void insert(int value) {
        insertRecursive(value, root);
    }

    public Node search(int value) {
        return searchRecursive(value, root);
    }

    private void insertRecursive(int value, Node node) {
        if(node == null) {
            node = new Node(null, null, value);
        }

        if(value < node.getValue()) {
            insertRecursive(value, node.getLeft());
        } else if (value > node.getValue()) {
            insertRecursive(value, node.getRight());
        }
    }

    private Node searchRecursive(int value, Node node) {
        if(node == null) {
            return null;
        } else if(value == node.getValue()) {
            return node;
        }

        if(value < node.getValue()) {
            return searchRecursive(value, node.getLeft());
        }
        else if (value > node.getValue()) {
            return searchRecursive(value, node.getRight());
        } else {
            return null;
        }
    }
}
