package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;

public class GameOfThronesTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.gameOfThrones().character(), matchesRegularExpression("[A-Za-z'\\-\\(\\) ]+"));
    }

    @Test
    public void house() {
        assertThat(this.faker.gameOfThrones().house(), matchesRegularExpression("[A-Za-z' ]+"));
    }

    @Test
    public void city() {
        assertThat(this.faker.gameOfThrones().city(), matchesRegularExpression("[A-Za-z' ]+"));
    }

    @Test
    public void dragon() {
        assertThat(this.faker.gameOfThrones().dragon(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void quote() {
        assertThat(this.faker.gameOfThrones().quote(), not(is(emptyOrNullString())));
    }
}
