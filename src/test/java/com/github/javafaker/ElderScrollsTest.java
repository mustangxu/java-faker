

package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

public class ElderScrollsTest extends AbstractFakerTest  {

    @Test
    public void testCity() {
        assertThat(this.faker.elderScrolls().city(),
            not(is(emptyOrNullString())));
    }

    @Test
    public void testCreature() {
        assertThat(this.faker.elderScrolls().creature(),
            not(is(emptyOrNullString())));
    }

    @Test
    public void testDragon() {
        assertThat(this.faker.elderScrolls().dragon(),
            not(is(emptyOrNullString())));
    }

    @Test
    public void testFirstName() {
        assertThat(this.faker.elderScrolls().firstName(),
            not(is(emptyOrNullString())));
    }

    @Test
    public void testLastName() {
        assertThat(this.faker.elderScrolls().lastName(),
            not(is(emptyOrNullString())));
    }

    @Test
    public void testRace() {
        assertThat(this.faker.elderScrolls().race(),
            not(is(emptyOrNullString())));
    }

    @Test
    public void testRegion() {
        assertThat(this.faker.elderScrolls().region(),
            not(is(emptyOrNullString())));
    }

    @Test
    public void testQuote() {
        assertThat(this.faker.elderScrolls().quote(),
            not(is(emptyOrNullString())));
    }
}