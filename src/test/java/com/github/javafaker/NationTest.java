package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NationTest extends AbstractFakerTest {

    @Test
    public void nationality() {
        assertThat(this.faker.nation().nationality(), matchesRegularExpression("\\P{Cc}+"));
    }

    @Test
    public void language() {
        assertThat(this.faker.nation().language(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void capitalCity() {
        assertThat(this.faker.nation().capitalCity(), matchesRegularExpression("[A-Za-z .'()-]+"));
    }

    @Test
    public void flag() {
        String flag = this.faker.nation().flag();

        // all utf8 emoji flags are at least 4 characters long and start with the same char
        assertThat(flag.length(), is(greaterThanOrEqualTo(4)));
        assertThat(flag.charAt(0), is('\uD83C'));
    }

}
