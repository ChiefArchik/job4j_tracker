package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function =  new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResult() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(3, 7, x -> Math.pow(x, 2) + x + 6);
        List<Double> expected = Arrays.asList(18D, 26D, 36D, 48D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResult() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(4, x));
        List<Double> expected = Arrays.asList(1024D, 4096D, 16384D);
        assertThat(result, is(expected));
    }
}