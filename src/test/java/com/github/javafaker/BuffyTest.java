package com.github.javafaker;

import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class BuffyTest extends AbstractFakerTest {
    @Test
    public void testCharacters() {
        assertThat(this.faker.buffy().characters(), isStringWithContents());
    }

    @Test
    public void testQuotes() {
        assertThat(this.faker.buffy().quotes(), isStringWithContents());
    }

    @Test
    public void testCelebrities() {
        assertThat(this.faker.buffy().celebrities(), isStringWithContents());
    }

    @Test
    public void testBigBads() {
        assertThat(this.faker.buffy().bigBads(), isStringWithContents());
    }

    @Test
    public void testEpisodes() {
        assertThat(this.faker.buffy().episodes(), isStringWithContents());
    }
}
