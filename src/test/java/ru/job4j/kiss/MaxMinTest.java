package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        MaxMin mm = new MaxMin();
        int rsl = mm.max(List.of(-1, 34, 23, 0, 1, 56), Comparator.comparingInt(x -> x));
        int expected = 56;
        assertEquals(expected, rsl);
    }

    @Test
    public void min() {
        MaxMin mm = new MaxMin();
        int rsl = mm.min(List.of(-17, 34, 23, 0, 1, -2), Comparator.comparingInt(x -> x));
        int expected = -17;
        assertEquals(expected, rsl);
    }

    @Test
    public void compare() {
        MaxMin mm = new MaxMin();
        int rsl = mm.compare(List.of(34, 23, 0, 1), (x, y) -> x - y == 11);
        int expected = 34;
        assertEquals(expected, rsl);
    }
}