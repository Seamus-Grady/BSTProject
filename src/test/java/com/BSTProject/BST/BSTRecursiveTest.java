package com.BSTProject.BST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTRecursiveTest {
    BSTRecursive testBstRecursive;
    Node testRootNode;

    @BeforeEach
    public void setUp() {
        this.testBstRecursive = new BSTRecursive();
        this.testRootNode = new Node(5);
    }

    @Test
    public void testCountRecrusiveNullNode() {
        assertEquals(0, testBstRecursive.countRecursive(null));
    }

    @Test
    public void testCountLeftAndRight() {
        this.testRootNode.setRight(new Node(10));
        this.testRootNode.setLeft(new Node(1));

        assertEquals(3, testBstRecursive.countRecursive(this.testRootNode));
    }

    @Test
    public void testSearchRecursiveNullNode() {
        assertNull(this.testBstRecursive.searchRecursive(4, null));
    }

    @Test
    public void testSearchRecursiveNodeWithValue() {
        Node result = this.testBstRecursive.searchRecursive(5, this.testRootNode);

        assertNotNull(result);
        assertEquals(5, result.getValue());
    }

    @Test
    public void testSearchRecursiveNodeWithoutValue() {
        assertNull(this.testBstRecursive.searchRecursive(3, this.testRootNode));
    }

    @Test
    public void testSearchRecursiveLeftNodeWithValue() {
        this.testRootNode.setLeft(new Node(1));

        Node result = this.testBstRecursive.searchRecursive(1, this.testRootNode);

        assertNotNull(result);
        assertEquals(1, result.getValue());
    }

    @Test
    public void testSearchRecursiveRightNodeWithValue() {
        this.testRootNode.setRight(new Node(10));

        Node result = this.testBstRecursive.searchRecursive(10, this.testRootNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
    }

    @Test
    public void testInsertLeftLeaf() {
        this.testBstRecursive.insertRecursive(3, this.testRootNode);

        assertEquals(3, this.testRootNode.getLeft().getValue());
    }

    @Test
    public void testInsertLeftWithLeftChild() {
        this.testBstRecursive.insertRecursive(3, this.testRootNode);
        this.testBstRecursive.insertRecursive(1, this.testRootNode);

        assertEquals(1, this.testRootNode.getLeft().getLeft().getValue());
    }

    @Test
    public void testInsertRightLeaf() {
        this.testBstRecursive.insertRecursive(10, this.testRootNode);

        assertEquals(10, this.testRootNode.getRight().getValue());
    }

    @Test
    public void testInsertRightWithRightChild() {
        this.testBstRecursive.insertRecursive(8, this.testRootNode);
        this.testBstRecursive.insertRecursive(10, this.testRootNode);

        assertEquals(10, this.testRootNode.getRight().getRight().getValue());
    }

    @Test
    public void testInsertRightWithLeftChild() {
        this.testBstRecursive.insertRecursive(1, this.testRootNode);
        this.testBstRecursive.insertRecursive(3, this.testRootNode);

        assertEquals(3, this.testRootNode.getLeft().getRight().getValue());
    }

    @Test
    public void testInsertWithTwoChildren() {
        this.testBstRecursive.insertRecursive(3, testRootNode);
        this.testBstRecursive.insertRecursive(10, testRootNode);

        assertEquals(5, this.testRootNode.getValue());
        assertEquals(3, this.testRootNode.getLeft().getValue());
        assertEquals(10, this.testRootNode.getRight().getValue());
    }

    @Test
    public void testInsertLeftWithRightChild() {
        this.testBstRecursive.insertRecursive(10, this.testRootNode);
        this.testBstRecursive.insertRecursive(8, this.testRootNode);

        assertEquals(8, this.testRootNode.getRight().getLeft().getValue());
    }

    @Test
    public void testDeleteWithNullCurrentNode() { 
        Node result = this.testBstRecursive.deleteRecursive(5, null, this.testRootNode);

        assertNull(result);
    }

    @Test
    public void testDeleteWithLeftLeafNode() {
        this.testRootNode.setLeft(new Node(3));
        
        Node result = this.testBstRecursive.deleteRecursive(3, testRootNode.getLeft(), testRootNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
        assertEquals(1, this.testBstRecursive.countRecursive(this.testRootNode));
    }

    @Test
    public void testDeleteWithRightLeafNode() {
        this.testRootNode.setRight(new Node(10));
        
        Node result = this.testBstRecursive.deleteRecursive(10, testRootNode.getRight(), testRootNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
        assertEquals(1, this.testBstRecursive.countRecursive(this.testRootNode));
    }

    @Test
    public void testDeleteWithLeftChildAndNoRightChildLeftNode() {
        this.testRootNode.setLeft(new Node(3));
        this.testRootNode.getLeft().setLeft(new Node(1));

        Node result = this.testBstRecursive.deleteRecursive(3, testRootNode.getLeft(), testRootNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootNode));
        assertEquals(1, this.testRootNode.getLeft().getValue());
    }

    @Test
    public void testDeleteWithLeftChildAndNoRightChildRightNode() {
        this.testRootNode.setRight(new Node(8));
        this.testRootNode.getRight().setLeft(new Node(7));

        Node result = this.testBstRecursive.deleteRecursive(8, testRootNode.getRight(), testRootNode);

        assertNotNull(result);
        assertEquals(8, result.getValue());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootNode));
        assertEquals(7, this.testRootNode.getRight().getValue());
    }

    @Test
    public void testDeleteWithRightChildAndNoLeftChildRightNode() {
        this.testRootNode.setRight(new Node(7));
        this.testRootNode.getRight().setRight(new Node(10));

        Node result = this.testBstRecursive.deleteRecursive(7, testRootNode.getRight(), testRootNode);

        assertNotNull(result);
        assertEquals(7, result.getValue());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootNode));
        assertEquals(10, this.testRootNode.getRight().getValue());
    }

    @Test
    public void testDeleteWithRightChildAndNoLeftChildLeftNode() {
        this.testRootNode.setLeft(new Node(3));
        this.testRootNode.getLeft().setRight(new Node(4));

        Node result = this.testBstRecursive.deleteRecursive(3, testRootNode.getLeft(), testRootNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootNode));
        assertEquals(4, this.testRootNode.getLeft().getValue());
    }

    // @Test
    // public void testDeleteWithTwoChildrenNoMinLeftNode() {
    //     this.testBstRecursive.insertRecursive(10, testRootNode);
    //     this.testBstRecursive.insertRecursive(8, testRootNode);
    //     this.testBstRecursive.insertRecursive(12, testRootNode);
    //     this.testBstRecursive.insertRecursive(14, testRootNode);
        
    //     Node result = this.testBstRecursive.deleteRecursive(10, testRootNode, null);

    //     assertNotNull(result);
    //     assertEquals(10, result.getValue());
    //     assertEquals(12, this.testRootNode.getRight().getValue());
    //     assertEquals(8, this.testRootNode.getRight().getLeft().getValue());
    //     assertNull(this.testRootNode.getRight().getRight().getLeft());
    //     assertEquals(14, this.testRootNode.getRight().getRight().getValue());
    // }

    // @Test
    // public void testDeleteWithTwoChildrenMinLeftNode() {
    //     this.testBstRecursive.insertRecursive(10, testRootNode);
    //     this.testBstRecursive.insertRecursive(8, testRootNode);
    //     this.testBstRecursive.insertRecursive(14, testRootNode);
    //     this.testBstRecursive.insertRecursive(13, testRootNode);
    //     this.testBstRecursive.insertRecursive(12, testRootNode);
        
    //     Node result = this.testBstRecursive.deleteRecursive(10, testRootNode, null);

    //     assertNotNull(result);
    //     assertEquals(10, result.getValue());
    //     assertEquals(12, this.testRootNode.getRight().getValue());
    //     assertEquals(8, this.testRootNode.getRight().getLeft().getValue());
    //     assertEquals(14, this.testRootNode.getRight().getRight().getValue());
    //     assertEquals(13, this.testRootNode.getRight().getRight().getLeft().getValue());
    // }
}
