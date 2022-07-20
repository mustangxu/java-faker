package com.github.javafaker;

import com.github.javafaker.repeating.Repeat;
import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class DuneTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.dune().character(), matchesRegularExpression("[A-Za-z '\\-\"]+"));
    }

    @Test
    public void title() {
        assertThat(this.faker.dune().title(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void planet() {
        assertThat(this.faker.dune().planet(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void quote() {
        assertThat(this.faker.dune().quote(), matchesRegularExpression("\\P{Cc}+"));
    }

    @Test
    @Repeat(times = 10000)
    public void randomQuote() {
        assertThat(
                this.faker.dune().quote(this.faker.options().option(Dune.Quote.class)),
                matchesRegularExpression("\\P{Cc}+"));
    }

    @Test
    public void saying() {
        assertThat(this.faker.dune().saying(), matchesRegularExpression("\\P{Cc}+"));
    }

    @Test
    @Repeat(times = 10000)
    public void randomSaying() {
        assertThat(
                this.faker.dune().saying(this.faker.options().option(Dune.Saying.class)),
                matchesRegularExpression("\\P{Cc}+"));
    }

}
