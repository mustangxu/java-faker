package com.github.javafaker;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;

import org.junit.Test;

public class EnglandFootBallTest extends AbstractFakerTest{



    @Test
    public void testLeague() {
        var league = this.faker.englandfootball().league();
        assertThat(league, not(is(emptyOrNullString())));

    }

    @Test
    public void testTeam() {
        var team = this.faker.englandfootball().team();
        assertThat(team, not(is(emptyOrNullString())));

    }
}
