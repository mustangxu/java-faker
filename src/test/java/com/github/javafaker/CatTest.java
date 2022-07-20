package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatTest extends AbstractFakerTest {

    @Test
    public void name() {
        assertThat(this.faker.cat().name(), matchesRegularExpression("[A-Za-z'() 0-9-]+"));
    }

    @Test
    public void breed() {
        assertThat(this.faker.cat().breed(), matchesRegularExpression("[A-Za-z'() 0-9-,]+"));
    }

    @Test
    public void registry() {
        assertThat(this.faker.cat().registry(), matchesRegularExpression("[A-Za-zé'() 0-9-]+"));
    }
}
