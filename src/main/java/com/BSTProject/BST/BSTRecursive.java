package com.BSTProject.BST;

public class BSTRecursive {
    
    public BSTRecursive() {}

    public void insertRecursive(int value, Node node) {
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

    public Node searchRecursive(int value, Node node) {
        if(node == null) {
            return null;
        } else if(value == node.getValue()) {
            return node;
        }

        if(isLeftChild(value, node)) {
           return searchRecursive(value, node.getLeft());
        } else {
           return searchRecursive(value, node.getRight());
        }
    }

    public Node deleteRecursive(int value, Node current, Node previous) {
        if(current == null) {
            return null;
        }
        if(value == current.getValue()) {
            if(isLeaf(current)) {
                if(isLeftChild(value, previous)) {
                    previous.setLeft(null);
                } else {
                    previous.setRight(null);
                }
                return current;
            }
        }

        return null;
    }

    public int countRecursive(Node node) {
        if(node == null) {
            return 0;
        }

        return countRecursive(node.getLeft()) + 1 + countRecursive(node.getRight());
    }

    private boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private boolean isLeftChild(int value, Node node) {
        return value != node.getValue() && value < node.getValue();
    }
    
}
