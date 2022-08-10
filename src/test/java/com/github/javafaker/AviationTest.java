package com.github.javafaker;

import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class AviationTest extends AbstractFakerTest {

    @Test
    public void airport() {
        assertThat(this.faker.aviation().airport(), matchesRegularExpression("\\w{4}"));
    }

    @Test
    public void aircraft() {
        assertThat(this.faker.aviation().aircraft(), isStringWithContents());
    }

    @Test
    public void metar() {
        assertThat(this.faker.aviation().METAR(), isStringWithContents());
    }
}
