package com.github.javafaker;

import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class DogTest extends AbstractFakerTest {

    @Test
    public void name() {
        assertThat(this.faker.dog().name(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void breed() {
        assertThat(this.faker.dog().breed(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void sound() {
        assertThat(this.faker.dog().sound(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void memePhrase() {
        assertThat(this.faker.dog().memePhrase(), matchesRegularExpression("[A-Za-z0-9'\\/ ]+"));
    }

    @Test
    public void age() {
        assertThat(this.faker.dog().age(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void gender() {
        assertThat(this.faker.dog().gender(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void coatLength() {
        assertThat(this.faker.dog().coatLength(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void size() {
        assertThat(this.faker.dog().size(), matchesRegularExpression("[A-Za-z ]+"));
    }
}
