package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;

import org.junit.Test;

public class ChuckNorrisTest extends AbstractFakerTest {

    @Test
    public void testFact() {
        assertThat(this.faker.chuckNorris().fact(),
            not(is(emptyOrNullString())));
    }
}
