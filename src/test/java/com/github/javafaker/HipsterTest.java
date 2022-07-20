package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class HipsterTest extends AbstractFakerTest {

    @Test
    public void word() {
        assertThat(this.faker.hipster().word(), matchesRegularExpression("^([\\w-+&']+ ?)+$"));
    }
}
