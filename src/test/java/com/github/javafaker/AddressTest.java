package com.github.javafaker;

import static com.github.javafaker.matchers.IsANumber.isANumber;
import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

import org.junit.Test;

public class AddressTest extends AbstractFakerTest {

    private static final char decimalSeparator = new DecimalFormatSymbols().getDecimalSeparator();

    @Test
    public void testStreetAddressStartsWithNumber() {
        final var streetAddressNumber = this.faker.address().streetAddress();
        assertThat(streetAddressNumber, matchesRegularExpression("[0-9]+ .+"));
    }

    @Test
    public void testStreetAddressIsANumber() {
        final var streetAddressNumber = this.faker.address().streetAddressNumber();
        assertThat(streetAddressNumber, matchesRegularExpression("[0-9]+"));
    }

    @Test
    public void testLatitude() {
        String latStr;
        Double lat;
        for (var i = 0; i < 100; i++) {
            latStr = this.faker.address().latitude().replace(decimalSeparator, '.');
            assertThat(latStr, isANumber());
            lat = Double.valueOf(latStr);
            assertThat("Latitude is less then -90", lat, greaterThanOrEqualTo(-90.0));
            assertThat("Latitude is greater than 90", lat, lessThanOrEqualTo(90.0));
        }
    }

    @Test
    public void testLongitude() {
        String longStr;
        Double lon;
        for (var i = 0; i < 100; i++) {
            longStr = this.faker.address().longitude().replace(decimalSeparator, '.');
            assertThat(longStr, isANumber());
            lon = Double.valueOf(longStr);
            assertThat("Longitude is less then -180", lon, greaterThanOrEqualTo(-180.0));
            assertThat("Longitude is greater than 180", lon, lessThanOrEqualTo(180.0));
        }
    }

    @Test
    public void testTimeZone() {
        assertThat(this.faker.address().timeZone(), matchesRegularExpression("[A-Za-z_]+/[A-Za-z_]+[/A-Za-z_]*"));
    }

    @Test
    public void testState() {
        assertThat(this.faker.address().state(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void testCity() {
        assertThat(this.faker.address().city(), matchesRegularExpression("[A-Za-z'() ]+"));
    }

    @Test
    public void testCityName() {
        assertThat(this.faker.address().cityName(), matchesRegularExpression("[A-Za-z'() ]+"));
    }

    @Test
    public void testCountry() {
        assertThat(this.faker.address().country(), matchesRegularExpression("[A-Za-z\\- &.,'()\\d]+"));
    }

    @Test
    public void testCountryCode() {
        assertThat(this.faker.address().countryCode(), matchesRegularExpression("[A-Za-z ]+"));
    }

    @Test
    public void testStreetAddressIncludeSecondary() {
        assertThat(this.faker.address().streetAddress(true), not(is(emptyString())));
    }

    @Test
    public void testCityWithLocaleFranceAndSeed() {
        var seed = 1L;
        var firstFaker = new Faker(Locale.FRANCE, new Random(seed));
        var secondFaker = new Faker(Locale.FRANCE, new Random(seed));
        assertThat(firstFaker.address().city(), is(secondFaker.address().city()));
    }

    @Test
    public void testFullAddress() {
        assertThat(this.faker.address().fullAddress(), not(is(emptyString())));
    }

    @Test
    public void testZipCodeByState() {
        this.faker = new Faker(new Locale("en-US"));
        assertThat(this.faker.address().zipCodeByState(this.faker.address().stateAbbr()), matchesRegularExpression("[0-9]{5}"));
    }

    @Test
    public void testHungarianZipCodeByState() {
        this.faker = new Faker(new Locale("hu"));
        assertThat(this.faker.address().zipCodeByState(this.faker.address().stateAbbr()), matchesRegularExpression("[0-9]{4}"));
    }

    @Test
    public void testCountyByZipCode() {
        this.faker = new Faker(new Locale("en-US"));
        assertThat(this.faker.address().countyByZipCode("47732"), not(is(emptyString())));
    }

    @Test
    public void testStreetPrefix() {
        assertThat(this.faker.address().streetPrefix(), isStringWithContents());
    }
}
