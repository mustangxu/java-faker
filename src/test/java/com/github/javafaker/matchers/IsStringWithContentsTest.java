package com.github.javafaker.matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsStringWithContentsTest {

    private IsStringWithContents matcher;

    @BeforeEach
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
