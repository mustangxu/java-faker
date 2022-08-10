package com.github.javafaker;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamTest extends AbstractFakerTest {

    @Test
    public void testName() {
        assertThat(this.faker.team().name(), matchesRegularExpression("(\\w+( )?){2,4}"));
    }

    @Test
    public void testCreature() {
        assertThat(this.faker.team().creature(), matchesRegularExpression("\\w+( \\w+)?"));
    }

    @Test
    public void testState() {
        assertThat(this.faker.team().state(), matchesRegularExpression("(\\w+( )?){1,2}"));
    }


    @Test
    public void testStateWithZaLocale() {
        Faker zaFaker = new Faker(new Locale("en-ZA"));
        assertThat(zaFaker.team().state(), isStringWithContents());
    }
    @Test
    public void testSport() {
        assertThat(this.faker.team().sport(), matchesRegularExpression("(\\p{L}|\\s)+"));
    }


}
