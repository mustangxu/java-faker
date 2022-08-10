package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class UniversityTest extends AbstractFakerTest {

    @Test
    public void testName() {
        assertThat(this.faker.university().name(), matchesRegularExpression("[A-Za-z'() ]+"));
    }

    @Test
    public void testPrefix() {
        assertThat(this.faker.university().prefix(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void testSuffix() {
        assertThat(this.faker.university().suffix(), matchesRegularExpression("\\w+"));
    }
}
