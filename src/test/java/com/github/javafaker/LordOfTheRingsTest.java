package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Luka Obradovic (luka@vast.com)
 */
public class LordOfTheRingsTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.lordOfTheRings().character(), matchesRegularExpression("(?U)([\\w ]+ ?)+"));
    }

    @Test
    public void location() {
        assertThat(this.faker.lordOfTheRings().location(), matchesRegularExpression("(?U)([\\w'\\- ]+ ?)+"));
    }
}
