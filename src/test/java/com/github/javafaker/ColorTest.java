package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class ColorTest extends AbstractFakerTest {

    @Test
    public void testName() {
        assertThat(this.faker.color().name(), matchesRegularExpression("(\\w+ ?){1,2}"));
    }

    @Test
    public void testHex() {
        assertThat(this.faker.color().hex(), matchesRegularExpression("^#[0-9A-F]{6}$"));
    }

    @Test
    public void testHexNoHashSign() {
        assertThat(this.faker.color().hex(false), matchesRegularExpression("^[0-9A-F]{6}$"));
    }
}
