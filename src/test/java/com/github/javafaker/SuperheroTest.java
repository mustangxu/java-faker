package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SuperheroTest extends AbstractFakerTest {

    @Test
    public void testName() {
        assertThat(this.faker.superhero().name(), matchesRegularExpression("[A-Za-z' -/]+"));
    }

    @Test
    public void testPrefix() {
        assertThat(this.faker.superhero().prefix(), matchesRegularExpression("[A-Za-z -]+"));
    }

    @Test
    public void testSuffix() {
        assertThat(this.faker.superhero().suffix(), matchesRegularExpression("[A-Za-z -]+"));
    }

    @Test
    public void testPower() {
        assertThat(this.faker.superhero().power(), matchesRegularExpression("[A-Za-z/ -]+"));
    }

    @Test
    public void testDescriptor() {
        assertThat(this.faker.superhero().descriptor(), matchesRegularExpression("[A-Za-z' -]+"));
    }
}
