package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class AquaTeenHungerForceTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.aquaTeenHungerForce().character(), matchesRegularExpression("[A-Za-z .]+"));
    }

}
