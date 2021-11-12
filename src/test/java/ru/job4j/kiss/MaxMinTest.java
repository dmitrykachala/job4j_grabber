package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        MaxMin mm = new MaxMin();
        int rsl = mm.max(List.of(34, 23, 0, 1), Comparator.comparingInt(x -> x));
        int expected = 34;
        assertEquals(expected, rsl);
    }

    @Test
    public void min() {
        MaxMin mm = new MaxMin();
        int rsl = mm.min(List.of(34, 23, 0, 1), Comparator.comparingInt(x -> x));
        int expected = 0;
        assertEquals(expected, rsl);
    }
}