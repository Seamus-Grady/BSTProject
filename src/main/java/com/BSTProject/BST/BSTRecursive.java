package com.BSTProject.BST;
import com.BSTProject.Node.BSTNode;

class BSTRecursive {
    
    public BSTRecursive() {}

    public void insertRecursive(int value, BSTNode BSTNode) {
        if(value == BSTNode.getValue()) {
            return;
        }
        if(BSTNode.getLeft() == null && isValueLessThanNodeValue(value, BSTNode)) {
            BSTNode nodeToInsert = new BSTNode(value);
            BSTNode.setLeft(nodeToInsert);
            nodeToInsert.setParent(BSTNode);
            return;
        }
        if(BSTNode.getRight() == null && !isValueLessThanNodeValue(value, BSTNode)) {
            BSTNode nodeToInsert = new BSTNode(value);
            BSTNode.setRight(nodeToInsert);
            nodeToInsert.setParent(BSTNode);
            return;
        } else {
            if(isValueLessThanNodeValue(value, BSTNode)) {
                insertRecursive(value, BSTNode.getLeft());
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

    public BSTNode deleteRecursive(int value, BSTNode current, BSTNode previous) {
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

    private BSTNode deleteLeafOrOneChild(int value, BSTNode current, BSTNode previous) {
        BSTNode BSTNodeToSet = null;
        if(hasOnlyOneChild(current)) {
            BSTNodeToSet = current.getLeft() != null? current.getLeft() : current.getRight();
        }

        if(isValueLessThanNodeValue(value, previous)) {
            previous.setLeft(BSTNodeToSet);
        } else {
            previous.setRight(BSTNodeToSet);
        }
        
        return current;
    }

    private BSTNode deleteWithTwoChildren(BSTNode current, BSTNode previous) {
        BSTNode BSTNodeToDelete;
        if(current.getLeft() == null) {
            previous.setRight(current.getRight());
            BSTNodeToDelete = current;
        } else {
            BSTNodeToDelete = findAndDeleteMinNodeOnLeftSide(current.getLeft(), current);
        }

        swapValueBetweenTwoNodes(previous, BSTNodeToDelete);
        return BSTNodeToDelete;
    }

    private BSTNode findAndDeleteMinNodeOnLeftSide(BSTNode current, BSTNode previous) {
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

    private void swapValueBetweenTwoNodes(BSTNode BSTNode1, BSTNode BSTNode2) {
        int node1Value = BSTNode1.getValue();
        BSTNode1.setValue(BSTNode2.getValue());
        BSTNode2.setValue(node1Value);
    }
    
}
