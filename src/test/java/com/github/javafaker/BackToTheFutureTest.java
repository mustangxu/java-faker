package com.github.javafaker;

import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class BackToTheFutureTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.backToTheFuture().character(), isStringWithContents());
    }

    @Test
    public void date() {
        assertThat(this.faker.backToTheFuture().date(), matchesRegularExpression("([A-za-z]{3,8}) ([1-9]|[1-2]\\d|3[0-1]), (18[8-9]\\d|19[0-9]\\d|200\\d|201[0-5])"));
    }

    @Test
    public void quote() {
        assertThat(this.faker.backToTheFuture().quote(), isStringWithContents());
    }
}
