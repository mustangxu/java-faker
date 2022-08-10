package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.Test;

public class HarryPotterTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.harryPotter().character(), matchesRegularExpression("[A-Za-z,\\-\\.\\(\\) ]+"));
    }

    @Test
    public void location() {
        assertThat(this.faker.harryPotter().location(), matchesRegularExpression("[A-Za-z0-9'\\. &,/]+"));
    }

    @Test
    public void quote() {
        assertThat(this.faker.harryPotter().quote(), not(is(emptyOrNullString())));
    }

    @Test
    public void book() {
        assertThat(this.faker.harryPotter().book(), matchesRegularExpression("Harry Potter and the ([A-Za-z'\\-]+ ?)+"));
    }

    @Test
    public void house() {
        assertThat(this.faker.harryPotter().house(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void spell() {
        assertThat(this.faker.harryPotter().spell(), matchesRegularExpression("[A-Za-z ]+"));
    }
}
