package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class CompanyTest extends AbstractFakerTest {

    @Test
    public void testName() {
        assertThat(this.faker.company().name(), matchesRegularExpression("[A-Za-z\\-&', ]+"));
    }

    @Test
    public void testSuffix() {
        assertThat(this.faker.company().suffix(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void testIndustry() {
        assertThat(this.faker.company().industry(), matchesRegularExpression("(\\w+([ ,&/-]{1,3})?){1,4}+"));
    }

    @Test
    public void testBuzzword() {
        assertThat(this.faker.company().buzzword(), matchesRegularExpression("(\\w+[ /-]?){1,3}"));
    }

    @Test
    public void testCatchPhrase() {
        assertThat(this.faker.company().catchPhrase(), matchesRegularExpression("(\\w+[ /-]?){1,9}"));
    }

    @Test
    public void testBs() {
        assertThat(this.faker.company().bs(), matchesRegularExpression("(\\w+[ /-]?){1,9}"));
    }

    @Test
    public void testLogo() {
        assertThat(this.faker.company().logo(), matchesRegularExpression("https://pigment.github.io/fake-logos/logos/medium/color/\\d+\\.png"));
    }

    @Test
    public void testProfession() {
        assertThat(this.faker.company().profession(), matchesRegularExpression("[a-z ]+"));
    }

    @Test
    public void testUrl() {
        var regexp = "(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])";
        assertThat(this.faker.company().url(), matchesRegularExpression(regexp));
    }
}
