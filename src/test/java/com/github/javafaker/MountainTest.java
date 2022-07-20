package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class MountainTest extends AbstractFakerTest {
    @Test
    public void testMountainName() {
        var mountainName = this.faker.mountain().name();
        assertThat(mountainName, not(is(emptyOrNullString())));
    }

    @Test
    public void testMountainLeague() {
        var mountainLeague = this.faker.mountain().range();
        assertThat(mountainLeague, not(is(emptyOrNullString())));
    }
}
