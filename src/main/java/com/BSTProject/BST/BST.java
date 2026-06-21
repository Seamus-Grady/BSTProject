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

    public int count() {
        return countRecursive(root);
    }

    private void insertRecursive(int value, Node node) {
        if(node == null) {
            this.root = new Node(value);
            return;
        }

        if(value < node.getValue()) {
            if(isLeaf(node)) {
                node.setLeft(new Node(value));
            } else {
                insertRecursive(value, node.getLeft());   
            }         
        }
        else if (value > node.getValue()) {
            if(isLeaf(node)) {
                node.setRight(new Node(value));
            } else {
                insertRecursive(value, node.getRight());
            }
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
        }

        return null;
    }

    private int countRecursive(Node node) {
        if(node == null) {
            return 0;
        }

        return countRecursive(node.getLeft()) + 1 + countRecursive(node.getRight());
    }

    private boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }
}
