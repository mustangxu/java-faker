package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class HowIMetYourMotherTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.howIMetYourMother().character(), matchesRegularExpression("^(\\w+\\.?\\s?)+$"));
    }

    @Test
    public void catchPhrase() {
        assertFalse(this.faker.howIMetYourMother().catchPhrase().isEmpty());
    }

    @Test
    public void highFive() {
        assertThat(this.faker.howIMetYourMother().highFive(), matchesRegularExpression("^(\\w+-?\\s?)+$"));
    }

    @Test
    public void quote() {
        assertFalse(this.faker.howIMetYourMother().quote().isEmpty());
    }
}
