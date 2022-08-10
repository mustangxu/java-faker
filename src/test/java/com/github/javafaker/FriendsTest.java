package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.Test;

public class FriendsTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.friends().character(), matchesRegularExpression("[A-Za-z .,]+"));
    }

    @Test
    public void location() {
        assertThat(this.faker.friends().location(), matchesRegularExpression("[\\w.', ]+"));
    }

    @Test
    public void quote() {
        assertThat(this.faker.friends().quote(), not(is(emptyOrNullString())));
    }
}
