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
            if(isLeaf(current) || hasOnlyOneChild(current)) {
                return deleteLeafOrOneChild(value, current, previous);
            } else {
                return deleteWithTwoChildren(current.getRight(), current);
            } 
        }

        return isValueLessThanNodeValue(value, current)? deleteRecursive(value, current.getLeft(), current) :  deleteRecursive(value, current.getRight(), current);
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

    private Node deleteLeafOrOneChild(int value, Node current, Node previous) {
        Node nodeToSet = null;
        if(hasOnlyOneChild(current)) {
            nodeToSet = current.getLeft() != null? current.getLeft() : current.getRight();
        }

        if(isValueLessThanNodeValue(value, previous)) {
            previous.setLeft(nodeToSet);
        } else {
            previous.setRight(nodeToSet);
        }
        
        return current;
    }

    private Node deleteWithTwoChildren(Node current, Node previous) {
        Node nodeToDelete;
        if(current.getLeft() == null) {
            previous.setRight(current.getRight());
            nodeToDelete = current;
        } else {
            nodeToDelete = findAndDeleteMinNodeOnLeftSide(current.getLeft(), current);
        }

        swapValueBetweenTwoNodes(previous, nodeToDelete);
        return nodeToDelete;
    }

    private Node findAndDeleteMinNodeOnLeftSide(Node current, Node previous) {
        if(current == null) { 
            return null;
        }
        if(current.getLeft() == null) {
            previous.setLeft(current.getRight());
            return current;
        } else {
            return findAndDeleteMinNodeOnLeftSide(current.getLeft(), current);
        }
    }

    private void swapValueBetweenTwoNodes(Node node1, Node node2) {
        int node1Value = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(node1Value);
    }
    
}
