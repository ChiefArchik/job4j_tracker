package ru.job4j.inheritance;


import org.junit.Test;
import static org.junit.Assert.*;

public class JSONReportTest {

    @Test
    public void whenTestGenerateMethod() {
        String ln = System.lineSeparator();
        String expected = "{" + ln
                + "\t\"name\" : \"Report`s name\"," + ln
                + "\t\"body\" : \"Report`s body\"" + ln
                + "}";
        String name = "Report`s name";
        String body = "Report`s body";
        String result = new JSONReport().generate(name, body);
        assertEquals(expected, result);
        System.out.println(result);
    }
}