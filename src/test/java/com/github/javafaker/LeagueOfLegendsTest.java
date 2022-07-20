package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class LeagueOfLegendsTest extends AbstractFakerTest {

    @Test
    public void champion() {
        assertThat(this.faker.leagueOfLegends().champion(), matchesRegularExpression("^(\\w+\\.?-?'?\\s?&?\\s?)+$"));
    }

    @Test
    public void location() {
        assertThat(this.faker.leagueOfLegends().location(), matchesRegularExpression("^(\\w+\\s?)+$"));
    }

    @Test
    public void quote() {
        assertFalse(this.faker.leagueOfLegends().quote().isEmpty());
    }

    @Test
    public void summonerSpell() {
        assertThat(this.faker.leagueOfLegends().summonerSpell(), matchesRegularExpression("^(\\w+\\s?!?)+$"));
    }

    @Test
    public void masteries() {
        assertThat(this.faker.leagueOfLegends().masteries(), matchesRegularExpression("^(\\w+\\s?'?)+$"));
    }

    @Test
    public void rank() {
        assertThat(this.faker.leagueOfLegends().rank(), matchesRegularExpression("^\\w+(\\s[IV]+)?$"));
    }
}
