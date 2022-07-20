package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;

import org.junit.Test;

public class WeatherTest extends AbstractFakerTest {

    @Test
    public void description() {
        assertThat(this.faker.weather().description(), not(is(emptyOrNullString())));
    }

    @Test
    public void temperatureCelsius() {
        assertThat(this.faker.weather().temperatureCelsius(), matchesRegularExpression("[-]?\\d+°C"));
    }

    @Test
    public void temperatureFahrenheit() {
        assertThat(this.faker.weather().temperatureFahrenheit(), matchesRegularExpression("[-]?\\d+°F"));
    }

    @Test
    public void temperatureCelsiusInRange() {
        for (var i = 1; i < 100; i++) {
            assertThat(this.faker.weather().temperatureCelsius(-5, 5), matchesRegularExpression("[-]?[0-5]°C"));
        }
    }

    @Test
    public void temperatureFahrenheitInRange() {
        for (var i = 1; i < 100; i++) {
            assertThat(this.faker.weather().temperatureFahrenheit(-5, 5), matchesRegularExpression("[-]?[0-5]°F"));
        }
    }
}