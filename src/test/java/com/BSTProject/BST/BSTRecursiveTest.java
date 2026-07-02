package com.BSTProject.BST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.BSTProject.Node.BSTNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTRecursiveTest {
    BSTRecursive testBstRecursive;
    BSTNode testRootBSTNode;

    @BeforeEach
    public void setUp() {
        this.testBstRecursive = new BSTRecursive();
        this.testRootBSTNode = new BSTNode(5);
    }

    @Test
    public void testInsertLeftLeaf() {
        this.testBstRecursive.insertRecursive(3, this.testRootBSTNode);

        assertEquals(3, this.testRootBSTNode.getLeft().getValue());
    }

    @Test
    public void testInsertLeftWithLeftChild() {
        this.testBstRecursive.insertRecursive(3, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(1, this.testRootBSTNode);

        assertEquals(1, this.testRootBSTNode.getLeft().getLeft().getValue());
        assertEquals(3, this.testRootBSTNode.getLeft().getLeft().getParent().getValue());
    }

    @Test
    public void testInsertRightLeaf() {
        this.testBstRecursive.insertRecursive(10, this.testRootBSTNode);

        assertEquals(10, this.testRootBSTNode.getRight().getValue());
    }

    @Test
    public void testInsertRightWithRightChild() {
        this.testBstRecursive.insertRecursive(8, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(10, this.testRootBSTNode);

        assertEquals(10, this.testRootBSTNode.getRight().getRight().getValue());
        assertEquals(8, this.testRootBSTNode.getRight().getRight().getParent().getValue());
    }

    @Test
    public void testInsertRightWithLeftChild() {
        this.testBstRecursive.insertRecursive(1, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(3, this.testRootBSTNode);

        assertEquals(3, this.testRootBSTNode.getLeft().getRight().getValue());
        assertEquals(1, this.testRootBSTNode.getLeft().getRight().getParent().getValue());
    }

    @Test
    public void testInsertWithTwoChildren() {
        this.testBstRecursive.insertRecursive(3, testRootBSTNode);
        this.testBstRecursive.insertRecursive(10, testRootBSTNode);

        assertEquals(5, this.testRootBSTNode.getValue());
        assertEquals(3, this.testRootBSTNode.getLeft().getValue());
        assertEquals(10, this.testRootBSTNode.getRight().getValue());
        assertEquals(5, this.testRootBSTNode.getLeft().getParent().getValue());
        assertEquals(5, this.testRootBSTNode.getRight().getParent().getValue());
    }

    @Test
    public void testInsertLeftWithRightChild() {
        this.testBstRecursive.insertRecursive(10, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(8, this.testRootBSTNode);

        assertEquals(8, this.testRootBSTNode.getRight().getLeft().getValue());
        assertEquals(10, this.testRootBSTNode.getRight().getLeft().getParent().getValue());
    }

    @Test
    public void testInsertNoDuplicate() {
        this.testBstRecursive.insertRecursive(1, testRootBSTNode);
        this.testBstRecursive.insertRecursive(1, testRootBSTNode);


        assertEquals(2, this.testBstRecursive.countRecursive(testRootBSTNode));
    }

    @Test
    public void testCountRecrusiveNullNode() {
        assertEquals(0, testBstRecursive.countRecursive(null));
    }

    @Test
    public void testCountLeftAndRight() {
        this.testBstRecursive.insertRecursive(10, testRootBSTNode);
        this.testBstRecursive.insertRecursive(1, testRootBSTNode);

        assertEquals(3, testBstRecursive.countRecursive(this.testRootBSTNode));
    }

    @Test
    public void testSearchRecursiveNullNode() {
        assertNull(this.testBstRecursive.searchRecursive(4, null));
    }

    @Test
    public void testSearchRecursiveNodeWithValue() {
        BSTNode result = this.testBstRecursive.searchRecursive(5, this.testRootBSTNode);

        assertNotNull(result);
        assertEquals(5, result.getValue());
    }

    @Test
    public void testSearchRecursiveNodeWithoutValue() {
        assertNull(this.testBstRecursive.searchRecursive(3, this.testRootBSTNode));
    }

    @Test
    public void testSearchRecursiveLeftNodeWithValue() {
        this.testBstRecursive.insertRecursive(1, testRootBSTNode);

        BSTNode result = this.testBstRecursive.searchRecursive(1, this.testRootBSTNode);

        assertNotNull(result);
        assertEquals(1, result.getValue());
    }

    @Test
    public void testSearchRecursiveRightNodeWithValue() {
        this.testBstRecursive.insertRecursive(10, testRootBSTNode);

        BSTNode result = this.testBstRecursive.searchRecursive(10, this.testRootBSTNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
    }

    @Test
    public void testDeleteWithNullCurrentNode() { 
        BSTNode result = this.testBstRecursive.deleteRecursive(5, null);

        assertNull(result);
    }

    @Test
    public void testDeleteWithValueNotInTree() {
        BSTNode result = this.testBstRecursive.deleteRecursive(6, testRootBSTNode);

        assertNull(result);
    }

    @Test
    public void testDeleteWithLeftLeafNode() {
        this.testBstRecursive.insertRecursive(3, this.testRootBSTNode);
        
        BSTNode result = this.testBstRecursive.deleteRecursive(3, testRootBSTNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
        assertEquals(1, this.testBstRecursive.countRecursive(this.testRootBSTNode));
    }

    @Test
    public void testDeleteWithRightLeafNode() {
        this.testBstRecursive.insertRecursive(10, this.testRootBSTNode);
        
        BSTNode result = this.testBstRecursive.deleteRecursive(10, testRootBSTNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
        assertEquals(1, this.testBstRecursive.countRecursive(this.testRootBSTNode));
    }

    @Test
    public void testDeleteWithLeftChildAndNoRightChildLeftNode() {
        this.testBstRecursive.insertRecursive(3, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(1, this.testRootBSTNode);

        BSTNode result = this.testBstRecursive.deleteRecursive(3, testRootBSTNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
        assertNull(result.getParent());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootBSTNode));
        assertEquals(1, this.testRootBSTNode.getLeft().getValue());
        assertEquals(this.testRootBSTNode, this.testRootBSTNode.getLeft().getParent());
    }

    @Test
    public void testDeleteWithLeftChildAndNoRightChildRightNode() {
        this.testBstRecursive.insertRecursive(8, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(7, this.testRootBSTNode);

        BSTNode result = this.testBstRecursive.deleteRecursive(8, testRootBSTNode);

        assertNotNull(result);
        assertEquals(8, result.getValue());
        assertNull(result.getParent());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootBSTNode));
        assertEquals(7, this.testRootBSTNode.getRight().getValue());
        assertEquals(this.testRootBSTNode, this.testRootBSTNode.getRight().getParent());
    }

    @Test
    public void testDeleteWithRightChildAndNoLeftChildRightNode() {
        this.testBstRecursive.insertRecursive(7, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(10, this.testRootBSTNode);

        BSTNode result = this.testBstRecursive.deleteRecursive(7, testRootBSTNode);

        assertNotNull(result);
        assertEquals(7, result.getValue());
        assertNull(result.getParent());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootBSTNode));
        assertEquals(10, this.testRootBSTNode.getRight().getValue());
        assertEquals(this.testRootBSTNode, this.testRootBSTNode.getRight().getParent());
    }

    @Test
    public void testDeleteWithRightChildAndNoLeftChildLeftNode() {
        this.testBstRecursive.insertRecursive(3, this.testRootBSTNode);
        this.testBstRecursive.insertRecursive(4, this.testRootBSTNode);

        BSTNode result = this.testBstRecursive.deleteRecursive(3, testRootBSTNode);

        assertNotNull(result);
        assertEquals(3, result.getValue());
        assertNull(result.getParent());
        assertEquals(2, this.testBstRecursive.countRecursive(this.testRootBSTNode));
        assertEquals(4, this.testRootBSTNode.getLeft().getValue());
        assertEquals(this.testRootBSTNode, this.testRootBSTNode.getLeft().getParent());
    }

    @Test
    public void testDeleteWithTwoChildrenNoMinLeftNode() {
        this.testBstRecursive.insertRecursive(10, testRootBSTNode);
        this.testBstRecursive.insertRecursive(8, testRootBSTNode);
        this.testBstRecursive.insertRecursive(12, testRootBSTNode);
        this.testBstRecursive.insertRecursive(14, testRootBSTNode);
        
        BSTNode result = this.testBstRecursive.deleteRecursive(10, testRootBSTNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
        assertNull(result.getParent());
        assertEquals(12, this.testRootBSTNode.getRight().getValue());
        assertEquals(this.testRootBSTNode, this.testRootBSTNode.getRight().getParent());
        assertEquals(8, this.testRootBSTNode.getRight().getLeft().getValue());
        assertNull(this.testRootBSTNode.getRight().getRight().getLeft());
        assertEquals(14, this.testRootBSTNode.getRight().getRight().getValue());
        assertEquals(4, this.testBstRecursive.countRecursive(this.testRootBSTNode));
    }

    @Test
    public void testDeleteWithTwoChildrenMinLeftNode() {
        this.testBstRecursive.insertRecursive(10, testRootBSTNode);
        this.testBstRecursive.insertRecursive(8, testRootBSTNode);
        this.testBstRecursive.insertRecursive(14, testRootBSTNode);
        this.testBstRecursive.insertRecursive(13, testRootBSTNode);
        this.testBstRecursive.insertRecursive(12, testRootBSTNode);
        
        BSTNode result = this.testBstRecursive.deleteRecursive(10, testRootBSTNode);

        assertNotNull(result);
        assertEquals(10, result.getValue());
        assertNull(result.getParent());
        assertEquals(12, this.testRootBSTNode.getRight().getValue());
        assertEquals(this.testRootBSTNode, this.testRootBSTNode.getRight().getParent());
        assertEquals(8, this.testRootBSTNode.getRight().getLeft().getValue());
        assertEquals(14, this.testRootBSTNode.getRight().getRight().getValue());
        assertEquals(13, this.testRootBSTNode.getRight().getRight().getLeft().getValue());
        assertEquals(5, this.testBstRecursive.countRecursive(this.testRootBSTNode));
    }
}
