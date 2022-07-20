package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class EsportsTest extends AbstractFakerTest {

    @Test
    public void player() {
        assertThat(this.faker.esports().player(), matchesRegularExpression("(\\w|.)+"));
    }

    @Test
    public void team() {
        assertThat(this.faker.esports().team(),  matchesRegularExpression("((\\w|.)+ ?)+"));
    }

    @Test
    public void event() {
        assertThat(this.faker.esports().event(), matchesRegularExpression("(\\w+ ?)+"));
    }

    @Test
    public void league() {
        assertThat(this.faker.esports().league(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void game() {
        assertThat(this.faker.esports().game(), matchesRegularExpression("([\\w:.]+ ?)+"));
    }
}
