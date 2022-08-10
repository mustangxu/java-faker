package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

public class ShakespeareTest  extends AbstractFakerTest{

    @Test
    public void testHamletQuote() {
        assertThat(this.faker.shakespeare().hamletQuote(), not(is(emptyOrNullString())));
    }

    @Test
    public void testAsYouLikeItQuote() {
        assertThat(this.faker.shakespeare().asYouLikeItQuote(), not(is(emptyOrNullString())));
    }

    @Test
    public void testKingRichardIIIQuote() {
        assertThat(this.faker.shakespeare().kingRichardIIIQuote(), not(is(emptyOrNullString())));
    }

    @Test
    public void testRomeoAndJulietQuote() {
        assertThat(this.faker.shakespeare().romeoAndJulietQuote(), not(is(emptyOrNullString())));
    }

}
