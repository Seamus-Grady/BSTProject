package com.BSTProject.BST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.BSTProject.Node.BSTNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTTest {

    BST test;

    @BeforeEach
    public void setUp() {
        test = new BST();
    }

    @Test
    public void testInsertWithNullRoot() {
        this.test.insert(5);

        BSTNode result = this.test.search(5);

        assertNotNull(result);
        assertEquals(5, result.getValue());
    }
}
