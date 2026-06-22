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

        Node result = this.testBstRecursive.searchRecursive(3, this.testRootNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
    }

    @Test
    public void testInsertLeftWithLeftChild() {
        this.testRootNode.setLeft(new Node(3));
        this.testBstRecursive.insertRecursive(1, this.testRootNode);

        Node result = this.testBstRecursive.searchRecursive(1, this.testRootNode);

        assertNotNull(result);
        assertEquals(1, result.getValue());
    }

    @Test
    public void testInsertRightLeaf() {
        this.testBstRecursive.insertRecursive(10, this.testRootNode);

        Node result = this.testBstRecursive.searchRecursive(10, this.testRootNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
    }

    @Test
    public void testInsertRightWithRightChild() {
        this.testRootNode.setRight(new Node(8));
        this.testBstRecursive.insertRecursive(10, this.testRootNode);

        Node result = this.testBstRecursive.searchRecursive(10, this.testRootNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
    }

    @Test
    public void testInsertRightWithLeftChild() {
        this.testRootNode.setLeft(new Node(1));
        this.testBstRecursive.insertRecursive(3, this.testRootNode);

        Node result = this.testBstRecursive.searchRecursive(3, this.testRootNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
    }

    @Test
    public void testInsertLeftWithRightChild() {
        this.testRootNode.setRight(new Node(10));
        this.testBstRecursive.insertRecursive(8, this.testRootNode);

        Node result = this.testBstRecursive.searchRecursive(8, this.testRootNode);
        
        assertNotNull(result);
        assertEquals(8, result.getValue());
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
}
