package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

public class StarTrekTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.starTrek().character(), matchesRegularExpression("^(\\w+-?'?\\.?\\s?)+$"));
    }

    @Test
    public void location() {
        assertThat(this.faker.starTrek().location(), matchesRegularExpression("^(\\w+'?\\s?)+$"));
    }

    @Test
    public void specie() {
        assertThat(this.faker.starTrek().specie(), matchesRegularExpression("^(\\w+-?'?\\s?)+$"));
    }

    @Test
    public void villain() {
        assertThat(this.faker.starTrek().villain(), matchesRegularExpression("^(\\w+'?\\.?\\s?)+$"));
    }

    @Test
    public void klingon() { assertThat(this.faker.starTrek().klingon(), not(is(emptyOrNullString()))); }
}
