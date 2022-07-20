package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class HackerTest extends AbstractFakerTest {

    @Test
    public void testAbbreviation() {
        assertThat(this.faker.hacker().abbreviation(), matchesRegularExpression("[A-Z]{2,4}"));
    }

    @Test
    public void testAdjective() {
        assertThat(this.faker.hacker().adjective(), matchesRegularExpression("(\\w+[- ]?){1,2}"));
    }

    @Test
    public void testNoun() {
        assertThat(this.faker.hacker().noun(), matchesRegularExpression("\\w+( \\w+)?"));
    }

    @Test
    public void testVerb() {
        assertThat(this.faker.hacker().verb(), matchesRegularExpression("\\w+( \\w+)?"));
    }

    @Test
    public void testIngverb() {
        assertThat(this.faker.hacker().ingverb(), matchesRegularExpression("\\w+ing( \\w+)?"));
    }
}
