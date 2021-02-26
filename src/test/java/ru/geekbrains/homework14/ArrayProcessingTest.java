package ru.geekbrains.homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayProcessingTest {
    private ArrayProcessing ap;

    @BeforeEach
    public void init() {
        ap = new ArrayProcessing();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckArrayMethod")
    public void massTestCheckArray(ArrayList<Integer> arrayOr) {
        Assertions.assertTrue(ap.checkArray(arrayOr));
    }

    public static Stream<Arguments> dataForCheckArrayMethod() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(Arrays.asList(1, 1, 4, 1, 1, 4, 4))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(4, 4, 4, 4))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(1, 4, 4, 3))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(4, 1, 4, 1, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCutArrayMethod")
    public void massTestCutArray(ArrayList<Integer> arrayEx, ArrayList<Integer> arrayOr) {
        Assertions.assertEquals(arrayEx, ap.cutArray(arrayOr));
    }

    public static Stream<Arguments> dataForCutArrayMethod() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(Arrays.asList(1, 7)),
                        new ArrayList<>(Arrays.asList(1, 2, 1, 2, 2, 3, 4, 1, 7))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(2, 3, 2, 1, 7)),
                        new ArrayList<>(Arrays.asList(1, 2, 1, 4, 2, 3, 2, 1, 7))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(4, 1)),
                        new ArrayList<>(Arrays.asList(1, 4, 1)))
        );
    }

    @Test
    public void testExceptionCutArray() {
        Assertions.assertThrows(RuntimeException.class, () ->
                ap.cutArray(new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2, 3, 2, 1, 7))));
    }
}
