package com.github.javafaker;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class EnglandFootBallTest extends AbstractFakerTest{



    @Test
    public void testLeague() {
        var league = this.faker.englandfootball().league();
        assertThat(league, not(isEmptyOrNullString()));

    }

    @Test
    public void testTeam() {
        var team = this.faker.englandfootball().team();
        assertThat(team, not(isEmptyOrNullString()));

    }
}
