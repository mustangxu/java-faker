package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class FoodTest extends AbstractFakerTest {

    @Test
    public void ingredient() {
        assertThat(this.faker.food().ingredient(), matchesRegularExpression("[A-Za-z- ]+"));
    }

    @Test
    public void spice() {
        assertThat(this.faker.food().spice(), matchesRegularExpression("[A-Za-z1-9- ]+"));
    }

    @Test
    public void dish() {
        assertThat(this.faker.food().dish(), matchesRegularExpression("\\P{Cc}+"));
    }

    @Test
    public void fruit() {
        assertThat(this.faker.food().fruit(), matchesRegularExpression("[A-Za-z1-9- ]+"));
    }

    @Test
    public void vegetable() {
        assertThat(this.faker.food().vegetable(), matchesRegularExpression("[A-Za-z1-9- ]+"));
    }

    @Test
    public void sushi() {
        assertThat(this.faker.food().sushi(), matchesRegularExpression("[A-Za-z1-9- ]+"));
    }

    @Test
    public void measurement() {
        assertThat(this.faker.food().measurement(), matchesRegularExpression("[A-Za-z1-9/ ]+{2}"));
    }
}
