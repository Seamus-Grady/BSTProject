package com.BSTProject.BST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BSTTest {

    BST test;

    @BeforeAll
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
        assertEquals(1, test.count());
    }
    
}
