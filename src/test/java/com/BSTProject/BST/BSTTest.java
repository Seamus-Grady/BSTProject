package com.BSTProject.BST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTTest {

    BST test;

    @BeforeEach
    public void setUp() {
        test = new BST();
    }

    @Test
    public void testInsert() {
        test.insert(10);
        assertNotNull(test.search(10));
    }

    @Test
    public void testInsertNoDuplicate() {
        test.insert(10);
        test.insert(10);
        //assertEquals(1, test.count());
    }

    @Test
    public void testSearchWithValueInBST() {
        test.insert(10);
        assertNotNull(test.search(10));
    }

    @Test
    public void testSearchWithNoValueinBST() {
        assertNull(test.search(10));
    }
}
