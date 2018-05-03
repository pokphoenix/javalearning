package com.pok.tutorial.web.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class NumberControllerTest {

    @Test
    public void primeNumberTest() {

        NumberController meo = new NumberController();
        // meo.checkPrime(3);
        assertEquals(true, meo.checkPrime(3));
        assertTrue(meo.checkPrime(3));
    }

    // array sort
    @Test
    public void arraySortTest() {
        int[] numbers = { 1, 5, 4, 3, 2, 6 };
        Arrays.sort(numbers);
        int[] expectOutput = { 1, 2, 3, 4, 5, 6 };
        assertArrayEquals(expectOutput, numbers);
    }

    @Test(expected = NullPointerException.class)
    public void testArraySortWithNullCondition() {
        int[] numbers = null; // success
        // int[] numbers = {}; // fail
        Arrays.sort(numbers);

    }

    @Test(timeout = 100)
    public void testArraySortPerformance() {
        for (int i = 0; i < 1_000_000; i++) {
            int[] numbers = { i, i - 1, i + 1 };
            Arrays.sort(numbers);
        }
    }

}
