package com.example;

import static org.junit.Assert.assertEquals;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

public class ReverserTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {
        try (StringWriter writer = new StringWriter()) {
            Reverser reverser = new Reverser(writer);
            try (Reader reader = new InputStreamReader(ReverserTest.class.getResourceAsStream("/sample.txt"), "US-ASCII")) {
                reverser.reverse(reader);
            }
            writer.flush();
            String result = writer.toString();
            String expectation = "zyxwvutsrqponmlkjihgfedcba";
            assertEquals(expectation, result);
        }
    }

}
