package com.BSTProject.BST;

public class BSTRecursive {
    
    public BSTRecursive() {}

    public void insertRecursive(int value, Node node) {
        if(value == node.getValue()) {
            return;
        }
        if(node.getLeft() == null && isValueLessThanNodeValue(value, node)) {
            node.setLeft(new Node(value));
            return;
        }
        if(node.getRight() == null && !isValueLessThanNodeValue(value, node)) {
            node.setRight(new Node(value));
            return;
        } else {
            if(isValueLessThanNodeValue(value, node)) {
                insertRecursive(value, node.getLeft());
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

        return isValueLessThanNodeValue(value, node)? searchRecursive(value, node.getLeft()) : searchRecursive(value, node.getRight());
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
            } else {
                Node nodeToDelete;
                if(current.getRight() != null && current.getRight().getLeft() == null) {
                    nodeToDelete = current.getRight();
                    current.setRight(current.getRight().getRight());
                } else {
                    nodeToDelete = findAndDeleteMinNodeInRightTree(current.getRight(), current);
                }
                int newValue = current.getValue();
                current.setValue(nodeToDelete.getValue());
                nodeToDelete.setValue(newValue);
                return nodeToDelete;
            } 
            return current;
        }

        if(isValueLessThanNodeValue(value, current)) {
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
        return value < node.getValue();
    }

    private Node findAndDeleteMinNodeInRightTree(Node current, Node previous) {
        if(current.getLeft() == null) {
            previous.setLeft(current.getRight());
            return current;
        } else {
            return findAndDeleteMinNodeInRightTree(current.getLeft(), current);
        }
    }
    
}
