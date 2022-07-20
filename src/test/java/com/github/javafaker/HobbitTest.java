package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class HobbitTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.hobbit().character(), matchesRegularExpression("^(\\(?\\w+\\.?\\s?\\)?)+$"));
    }

    @Test
    public void thorinsCompany() {
        assertThat(this.faker.hobbit().thorinsCompany(), matchesRegularExpression("^(\\w+\\s?)+$"));
    }

    @Test
    public void quote() {
        assertFalse(this.faker.hobbit().quote().isEmpty());
    }

    @Test
    public void location() {
        assertThat(this.faker.hobbit().location(), matchesRegularExpression("^(\\w+'?-?\\s?)+$"));
    }
}
