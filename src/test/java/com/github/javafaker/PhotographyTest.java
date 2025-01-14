package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.javafaker.repeating.Repeat;

public class PhotographyTest extends AbstractFakerTest{

    @Test
    public void testAperture() {
        final var value = this.faker.photography().aperture();
        assertTrue(value.startsWith("f"));
    }

    @Test
    public void testTerm() {
        final var value = this.faker.photography().term();
        PhotographyTest.assertNonNullOrEmpty(value);
    }

    @Test
    public void brand() {
        final var value = this.faker.photography().brand();
        PhotographyTest.assertNonNullOrEmpty(value);
    }

    @Test
    public void camera() {
        final var value = this.faker.photography().camera();
        PhotographyTest.assertNonNullOrEmpty(value);
    }

    @Test
    public void lens() {
        final var value = this.faker.photography().lens();
        PhotographyTest.assertNonNullOrEmpty(value);
    }

    @Test
    public void genre() {
        final var value = this.faker.photography().genre();
        PhotographyTest.assertNonNullOrEmpty(value);
    }

    @Test
    public void imageTag() {
        final var value = this.faker.photography().imageTag();
        PhotographyTest.assertNonNullOrEmpty(value);
    }

    @Test
    @Repeat(times=7)
    public void shutter() {
        final var value = this.faker.photography().shutter();
        assertThat(value, matchesRegularExpression("\\d{1,}\\/{0,1}\\d*"));
    }

    @Test
    @Repeat(times=7)
    public void iso() {
        final var value = this.faker.photography().iso();
        assertThat(value, matchesRegularExpression("\\d{1,}"));
    }

    private static void assertNonNullOrEmpty(String value) {
        assertNotNull(value);
        assertFalse(value.isEmpty());
    }
}