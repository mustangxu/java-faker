package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.oneOf;

import org.junit.Test;

public class BoolTest extends AbstractFakerTest {

    @Test
    public void testBool() {
        for (var i = 0; i < 100; i++) {
            assertThat(this.faker.bool().bool(), is(oneOf(true, false)));
        }
    }
}
