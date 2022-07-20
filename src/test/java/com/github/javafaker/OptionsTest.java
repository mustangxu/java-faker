package com.github.javafaker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.oneOf;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OptionsTest extends AbstractFakerTest {

    private String[] options;

    @Before
    public void setupOptions() {
        this.options = new String[]{"A", "B", "C"};
    }

    @Test
    public void testOptionWithArray() {
        assertThat(this.faker.options().option(this.options),
            is(oneOf(this.options)));
    }

    @Test
    public void testOptionWithVarargsString() {
        assertThat(this.faker.options().option("A", "B", "C"),
            is(oneOf(this.options)));
    }

    @Test
    public void testOptionWithVarargsInteger() {
        Integer[] integerOptions = { 1, 3, 4, 5};
        assertThat(this.faker.options().option(1, 3, 4, 5),
            is(oneOf(integerOptions)));
    }

    @Test
    public void testOptionWithEnum() {
        assertThat(this.faker.options().option(Day.class),
            is(oneOf(Day.values())));
    }

    @Test
    public void testNextArrayElement() {
        Integer[] array = { 1, 2, 3, 5, 8, 13, 21 };

        for (var i = 1; i < 10; i++) {
            assertThat(this.faker.options().nextElement(array), is(in(array)));
        }
    }

    @Test
    public void testNextListElement() {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 13, 21);
        for (var i = 1; i < 10; i++) {
            assertThat(this.faker.options().nextElement(list), is(in(list)));
        }
    }

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
