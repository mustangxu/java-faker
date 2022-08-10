package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class BeerTest extends AbstractFakerTest {

    @Test
    public void testName() {
        assertThat(this.faker.beer().name(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }

    @Test
    public void testStyle() {
        assertThat(this.faker.beer().style(), matchesRegularExpression("[A-Za-z'() 0-9-]+"));
    }

    @Test
    public void testHop() {
        assertThat(this.faker.beer().hop(), matchesRegularExpression("[A-Za-z'’()\\. 0-9-]+"));
    }

    @Test
    public void testMalt() {
        assertThat(this.faker.beer().malt(), matchesRegularExpression("[A-Za-z'() 0-9-]+"));
    }

    @Test
    public void testYeast() {
        assertThat(this.faker.beer().yeast(), matchesRegularExpression("[\\p{L}'() 0-9-ö]+"));
    }
}
