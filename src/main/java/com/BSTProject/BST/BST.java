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
            this.root = new Node(value);
        }

        if(value < node.getValue()) {
            insertOrTraverse(value, node, node.getLeft());            
        }
        else if (value > node.getValue()) {
            insertOrTraverse(value, node, node.getRight());
        }
    }

    private Node searchRecursive(int value, Node node) {
        if(node == null) {
            return null;
        } else if(node != null && value == node.getValue()) {
            return node;
        }

        if(value < node.getValue()) {
           return searchRecursive(value, node.getLeft());
        }
        else if (value > node.getValue()) {
           return searchRecursive(value, node.getRight());
        }

        return null;
    }

    private boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private void insertOrTraverse(int value, Node current, Node next) {
        if(isLeaf(current)) {
            current.setRight(new Node(value));
        } else {
            insertRecursive(value, next);
        }
    }
}
