package ru.geekbrains.homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayProcessingTest {
    private ArrayProcessing ap;

    @BeforeEach
    public void init() {
        ap = new ArrayProcessing();
    }

    @Test
    public void testCheckArray() {
        Assertions.assertTrue(ap.checkArray(new ArrayList<>(Arrays.asList(4, 1, 4, 4, 1, 4))));
        Assertions.assertTrue(ap.checkArray(new ArrayList<>(Arrays.asList(4, 1))));
        Assertions.assertTrue(ap.checkArray(new ArrayList<>(Arrays.asList(1, 1, 4))));
    }

    @Test
    public void testCutArray() {
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(1, 7)),
                ap.cutArray(new ArrayList<>(Arrays.asList(1, 2, 1, 2, 2, 3, 4, 1, 7))));
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(2, 3, 2, 1, 7)),
                ap.cutArray(new ArrayList<>(Arrays.asList(1, 2, 1, 4, 2, 3, 2, 1, 7))));
        Assertions.assertThrows(RuntimeException.class, () ->
                ap.cutArray(new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2, 3, 2, 1, 7))));
    }

}
