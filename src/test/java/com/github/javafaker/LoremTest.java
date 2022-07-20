package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class LoremTest extends AbstractFakerTest {

    @Test
    public void shouldCreateFixedLengthString() {
        assertEquals(10, this.faker.lorem().fixedString(10).length());
        assertEquals(50, this.faker.lorem().fixedString(50).length());
        assertEquals(0, this.faker.lorem().fixedString(0).length());
        assertEquals(0, this.faker.lorem().fixedString(-1).length());
    }

    @Test
    public void wordShouldNotBeNullOrEmpty() {
        assertThat(this.faker.lorem().word(), not(is(emptyOrNullString())));
    }

    @Test
    public void testCharacter() {
        assertThat(String.valueOf(this.faker.lorem().character()), matchesRegularExpression("[a-z\\d]{1}"));
    }

    @Test
    public void testCharacterIncludeUpperCase() {
        assertThat(String.valueOf(this.faker.lorem().character(false)), matchesRegularExpression("[a-z\\d]{1}"));
        assertThat(String.valueOf(this.faker.lorem().character(true)), matchesRegularExpression("[a-zA-Z\\d]{1}"));
    }

    @Test
    public void testCharacters() {
        assertThat(this.faker.lorem().characters(), matchesRegularExpression("[a-z\\d]{255}"));
    }

    @Test
    public void testCharactersIncludeUpperCase() {
        assertThat(this.faker.lorem().characters(false), matchesRegularExpression("[a-z\\d]{255}"));
        assertThat(this.faker.lorem().characters(true), matchesRegularExpression("[a-zA-Z\\d]{255}"));
    }

    @Test
    public void testCharactersWithLength() {
        assertThat(this.faker.lorem().characters(2), matchesRegularExpression("[a-z\\d]{2}"));
        assertThat(this.faker.lorem().characters(500), matchesRegularExpression("[a-z\\d]{500}"));
        assertThat(this.faker.lorem().characters(0), is(emptyString()));
        assertThat(this.faker.lorem().characters(-1), is(emptyString()));
    }

    @Test
    public void testCharactersWithLengthIncludeUppercase() {
        assertThat(this.faker.lorem().characters(2, false), matchesRegularExpression("[a-z\\d]{2}"));
        assertThat(this.faker.lorem().characters(500, false), matchesRegularExpression("[a-z\\d]{500}"));
        assertThat(this.faker.lorem().characters(2, true), matchesRegularExpression("[a-zA-Z\\d]{2}"));
        assertThat(this.faker.lorem().characters(500, true), matchesRegularExpression("[a-zA-Z\\d]{500}"));
        assertThat(this.faker.lorem().characters(0, false), is(emptyString()));
        assertThat(this.faker.lorem().characters(-1, true), is(emptyString()));
    }

    @Test
    public void testCharactersMinimumMaximumLength() {
        assertThat(this.faker.lorem().characters(1, 10), matchesRegularExpression("[a-z\\d]{1,10}"));
    }

    @Test
    public void testCharactersMinimumMaximumLengthIncludeUppercase() {
        assertThat(this.faker.lorem().characters(1, 10, true), matchesRegularExpression("[a-zA-Z\\d]{1,10}"));
    }

    @Test
    public void testCharactersMinimumMaximumLengthIncludeUppercaseIncludeDigit() {
        assertThat(this.faker.lorem().characters(1, 10, false, false), matchesRegularExpression("[a-zA-Z]{1,10}"));
        assertThat(this.faker.lorem().characters(1, 10, true, true), matchesRegularExpression("[a-zA-Z\\d]{1,10}"));
    }

    @Test
    public void testSentence() {
        assertThat(this.faker.lorem().sentence(), matchesRegularExpression("(\\w+\\s?){4,10}\\."));
    }

    @Test
    public void testSentenceWithWordCount() {
        assertThat(this.faker.lorem().sentence(10), matchesRegularExpression("(\\w+\\s?){11,17}\\."));
    }

    @Test
    public void testSentenceWithWordCountAndRandomWordsToAdd() {
        assertThat(this.faker.lorem().sentence(10, 10), matchesRegularExpression("(\\w+\\s?){10,20}\\."));
    }

    @Test
    public void testSentenceFixedNumberOfWords() {
        assertThat(this.faker.lorem().sentence(10, 0), matchesRegularExpression("(\\w+\\s?){10}\\."));
    }

    @Test
    public void testWords() {
        assertThat(this.faker.lorem().words(), hasSize(greaterThanOrEqualTo(1)));
    }
}
