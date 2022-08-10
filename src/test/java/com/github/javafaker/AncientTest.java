package com.github.javafaker;

import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class AncientTest extends AbstractFakerTest {

    @Test
    public void god() {
        assertThat(this.faker.ancient().god(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void primordial() {
        assertThat(this.faker.ancient().primordial(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void titan() {
        assertThat(this.faker.ancient().titan(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void hero() {
        assertThat(this.faker.ancient().hero(), matchesRegularExpression("(?U)\\w+"));
    }

}
