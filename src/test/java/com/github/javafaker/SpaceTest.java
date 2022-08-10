package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class SpaceTest extends AbstractFakerTest {

    @Test
    public void planet() {
        assertThat(this.faker.space().planet(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void moon() {
        assertThat(this.faker.space().moon(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void galaxy() {
        assertThat(this.faker.space().galaxy(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void nebula() {
        assertThat(this.faker.space().nebula(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void starCluster() {
        assertThat(this.faker.space().starCluster(), matchesRegularExpression("(\\w+[ -]?){1,3}"));
    }

    @Test
    public void constellation() {
        assertThat(this.faker.space().constellation(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void star() {
        assertThat(this.faker.space().star(), matchesRegularExpression("(\\w+[ -]?){2,3}"));
    }

    @Test
    public void agency() {
        assertThat(this.faker.space().agency(), matchesRegularExpression("(\\w+ ?){2,5}"));
    }

    @Test
    public void agencyAbbreviation() {
        assertThat(this.faker.space().agencyAbbreviation(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void nasaSpaceCraft() {
        assertThat(this.faker.space().nasaSpaceCraft(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void company() {
        assertThat(this.faker.space().company(), matchesRegularExpression("((\\w|')+ ?){2,4}"));
    }

    @Test
    public void distanceMeasurement() {
        assertThat(this.faker.space().distanceMeasurement(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void meteorite() {
        assertThat(this.faker.space().meteorite(), matchesRegularExpression("(?U)([\\w()]+[ -–]?){1,4}"));
    }
}
