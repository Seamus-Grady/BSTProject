package com.BSTProject.BST;
import com.BSTProject.Node.BSTNode;

class BSTRecursive {
    
    public BSTRecursive() {}

    public void insertRecursive(int value, BSTNode BSTNode) {
        if(value == BSTNode.getValue()) {
            return;
        }
        if(isValueLessThanNodeValue(value, BSTNode)) {
            if(BSTNode.getLeft() == null) {
                BSTNode nodeToInsert = new BSTNode(value);
                BSTNode.setLeft(nodeToInsert);
                nodeToInsert.setParent(BSTNode);
            } else {
                insertRecursive(value, BSTNode.getLeft());
            }
        } else {
            if(BSTNode.getRight() == null) {
                BSTNode nodeToInsert = new BSTNode(value);
                BSTNode.setRight(nodeToInsert);
                nodeToInsert.setParent(BSTNode);
            } else {
                insertRecursive(value, BSTNode.getRight());
            }
        }
    }

    public BSTNode searchRecursive(int value, BSTNode BSTNode) {
        if(BSTNode == null) {
            return null;
        } else if(value == BSTNode.getValue()) {
            return BSTNode;
        }

        return isValueLessThanNodeValue(value, BSTNode)? searchRecursive(value, BSTNode.getLeft()) : searchRecursive(value, BSTNode.getRight());
    }

    public BSTNode deleteRecursive(int value, BSTNode current) {
        if(current == null) {
            return null;
        }
        if(value == current.getValue()) {
            if(isLeaf(current) || hasOnlyOneChild(current)) {
                return deleteLeafOrOneChild(value, current);
            } else {
                return deleteWithTwoChildren(current.getRight());
            } 
        }

        return isValueLessThanNodeValue(value, current)? deleteRecursive(value, current.getLeft()) :  deleteRecursive(value, current.getRight());
    }

    public int countRecursive(BSTNode BSTNode) {
        if(BSTNode == null) {
            return 0;
        }

        return countRecursive(BSTNode.getLeft()) + 1 + countRecursive(BSTNode.getRight());
    }

    private boolean isLeaf(BSTNode BSTNode) {
        return BSTNode.getLeft() == null && BSTNode.getRight() == null;
    }

    private boolean hasOnlyOneChild(BSTNode BSTNode) {
        return (BSTNode.getLeft() == null) ^ (BSTNode.getRight() == null);
    }

    private boolean isValueLessThanNodeValue(int value, BSTNode BSTNode) {
        return value < BSTNode.getValue();
    }

    private BSTNode deleteLeafOrOneChild(int value, BSTNode current) {
        BSTNode BSTNodeToSet = null;
        if(hasOnlyOneChild(current)) {
            BSTNodeToSet = current.getLeft() != null? current.getLeft() : current.getRight();
        }

        if(isValueLessThanNodeValue(value, current.getParent())) {
            current.getParent().setLeft(BSTNodeToSet);
        } else {
            current.getParent().setRight(BSTNodeToSet);
        }

        swapParentsAndDeleteNode(BSTNodeToSet, current);
        return current;
    }

    private BSTNode deleteWithTwoChildren(BSTNode current) {
        BSTNode BSTNodeToDelete;
        if(current.getLeft() == null) {
            current.getParent().setRight(current.getRight());
            BSTNodeToDelete = current;
        } else {
            BSTNodeToDelete = findAndDeleteMinNodeOnLeftSide(current.getLeft());
        }

        swapValueBetweenTwoNodes(current.getParent(), BSTNodeToDelete);
        swapParentsAndDeleteNode(BSTNodeToDelete.getRight(), BSTNodeToDelete);
        return BSTNodeToDelete;
    }

    private BSTNode findAndDeleteMinNodeOnLeftSide(BSTNode current) {
        if(current == null) { 
            return null;
        }
        if(current.getLeft() == null) {
            current.getParent().setLeft(current.getRight());
            return current;
        } else {
            return findAndDeleteMinNodeOnLeftSide(current.getLeft());
        }
    }

    private void swapValueBetweenTwoNodes(BSTNode BSTNode1, BSTNode BSTNode2) {
        int node1Value = BSTNode1.getValue();
        BSTNode1.setValue(BSTNode2.getValue());
        BSTNode2.setValue(node1Value);
    }

    private void swapParentsAndDeleteNode(BSTNode BSTNode1, BSTNode BSTNode2) {
        if(BSTNode1 != null) {
            BSTNode1.setParent(BSTNode2.getParent());
        }

        BSTNode2.setParent(null);
    }
    
}
