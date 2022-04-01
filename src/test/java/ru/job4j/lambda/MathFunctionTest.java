package ru.job4j.lambda;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MathFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        MathFunction function = new MathFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        MathFunction function = new MathFunction();
        List<Double> result = function.diapason(2, 4, x -> 2 * Math.pow(x, 2) + 3 * x + 1);
        List<Double> expected = Arrays.asList(15D, 28D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDemFunctionThenDemResults() {
        MathFunction function = new MathFunction();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(3D, 5D, 9D);
        assertThat(result, is(expected));
    }
}