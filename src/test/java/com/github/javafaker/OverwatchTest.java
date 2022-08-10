package com.github.javafaker;

import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;

public class OverwatchTest extends AbstractFakerTest {

    @Test
    public void hero() {
        assertThat(this.faker.overwatch().hero(), matchesRegularExpression("^(\\w+\\.?\\s?)+$"));
    }

    @Test
    public void location() {
        assertThat(this.faker.overwatch().location(), matchesRegularExpression("^(.+'?:?\\s?)+$"));
    }

    @Test
    public void quote() {
        assertFalse(this.faker.overwatch().quote().isEmpty());
    }
}
