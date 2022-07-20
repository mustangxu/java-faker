package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class StarCraftTest extends AbstractFakerTest {

    private final String noLeadingTrailingWhitespaceRegex = "^(?! )[A-Za-z0-9' ]*(?<! )$";

    @Test
    public void testUnit() {
        var unit = this.faker.starCraft().unit();
        assertThat(unit, not(is(emptyOrNullString())));
        assertThat(unit, matchesRegularExpression(this.noLeadingTrailingWhitespaceRegex));
    }

    @Test
    public void testBuilding() {
        var building = this.faker.starCraft().building();
        assertThat(building, not(is(emptyOrNullString())));
        assertThat(building, matchesRegularExpression(this.noLeadingTrailingWhitespaceRegex));
    }

    @Test
    public void testCharacter() {
        var character = this.faker.starCraft().character();
        assertThat(character, not(is(emptyOrNullString())));
        assertThat(character, matchesRegularExpression(this.noLeadingTrailingWhitespaceRegex));
    }

    @Test
    public void testPlanet() {
        var planet = this.faker.starCraft().planet();
        assertThat(planet, not(is(emptyOrNullString())));
        assertThat(planet, matchesRegularExpression(this.noLeadingTrailingWhitespaceRegex));
    }

}
