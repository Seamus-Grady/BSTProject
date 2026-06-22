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

        if(isValueLessThanNodeValue(value, node)) {
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
                if(isValueLessThanNodeValue(value, previous)) {
                    previous.setLeft(null);
                } else {
                    previous.setRight(null);
                }
            } else if(hasOnlyOneChild(current)) {
                Node nodeToSet;
                if(current.getLeft() != null) {
                    nodeToSet = current.getLeft();
                } else {
                    nodeToSet = current.getRight();
                }

                if(isValueLessThanNodeValue(value, previous)) {
                    previous.setLeft(nodeToSet);
                } else {
                    previous.setRight(nodeToSet);
                }
            } 
            return current;
        }

        if(isValueLessThanNodeValue(value, previous)) {
            return deleteRecursive(value, current.getLeft(), current);
        } else {
            return deleteRecursive(value, current.getRight(), current);        
        }
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

    private boolean hasOnlyOneChild(Node node) { 
        return (node.getLeft() == null) ^ (node.getRight() == null);
    }

    private boolean isValueLessThanNodeValue(int value, Node node) {
        return value != node.getValue() && value < node.getValue();
    }
    
}
