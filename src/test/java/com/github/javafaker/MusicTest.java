package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class MusicTest extends AbstractFakerTest {

    @Test
    public void instrument() {
        assertThat(this.faker.music().instrument(), matchesRegularExpression("\\w+ ?\\w+"));
    }

    @Test
    public void key() {
        assertThat(this.faker.music().key(), matchesRegularExpression("([A-Z])+(b|#){0,1}"));
    }

    @Test
    public void chord() {
        assertThat(this.faker.music().chord(), matchesRegularExpression("([A-Z])+(b|#){0,1}+(-?[a-zA-Z0-9]{0,4})"));
    }

    @Test
    public void genre() {
        assertThat(this.faker.music().genre(), matchesRegularExpression("[[ -]?\\w+]+"));
    }
}
