package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class DemographicTest extends AbstractFakerTest {

    @Test
    public void race() {
        assertThat(this.faker.demographic().race(), matchesRegularExpression("(\\w+ ?)+"));
    }

    @Test
    public void educationalAttainment() {
        assertThat(this.faker.demographic().educationalAttainment(), matchesRegularExpression("(?U)([\\w'-]+ ?)+"));
    }

    @Test
    public void demonym() {
        assertThat(this.faker.demographic().demonym(), matchesRegularExpression("(?U)([\\w'-]+ ?)+"));
    }

    @Test
    public void maritalStatus() {
        assertThat(this.faker.demographic().maritalStatus(), matchesRegularExpression("(\\w+ ?)+"));
    }

    @Test
    public void sex() {
        assertThat(this.faker.demographic().sex(), matchesRegularExpression("\\w+"));
    }
}
