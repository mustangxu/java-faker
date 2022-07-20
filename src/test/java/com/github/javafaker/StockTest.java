package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class StockTest extends AbstractFakerTest {

    @Test
    public void testNasdaq() {
        assertThat(this.faker.stock().nsdqSymbol(), not(is(emptyOrNullString())));
    }

    @Test
    public void testNYSE() {
        assertThat(this.faker.stock().nyseSymbol(), not(is(emptyOrNullString())));
    }

}
