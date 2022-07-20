package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class DragonBallTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.dragonBall().character(), matchesRegularExpression("^(\\w+\\.?\\s?-?)+$"));
    }
}
