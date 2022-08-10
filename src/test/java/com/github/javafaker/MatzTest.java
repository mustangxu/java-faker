package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.Test;

public class MatzTest extends AbstractFakerTest {

    @Test
    public void quote() {
        assertThat(this.faker.matz().quote(), not(is(emptyOrNullString())));
    }
}
