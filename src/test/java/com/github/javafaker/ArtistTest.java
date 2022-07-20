package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArtistTest extends AbstractFakerTest {

    @Test
    public void name() {
        assertThat(this.faker.artist().name(), matchesRegularExpression("(\\w+ ?){1,2}"));
    }
}
