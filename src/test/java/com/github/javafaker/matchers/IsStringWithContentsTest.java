package com.github.javafaker.matchers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IsStringWithContentsTest {

    private IsStringWithContents matcher;

    @Before
    public void before() {
        this.matcher = new IsStringWithContents();
    }

    @Test
    public void emptyStringShouldFail() {
        assertThat(this.matcher.matchesSafely(""), is(false));
    }

    @Test
    public void nullStringShouldFail() {
        assertThat(this.matcher.matchesSafely(null), is(false));
    }

    @Test
    public void stringShouldPass() {
        assertThat(this.matcher.matchesSafely("123"), is(true));
    }

    @Test
    public void whiteSpaceShouldFail() {
        assertThat(this.matcher.matchesSafely("    "), is(false));
    }
}
