package com.github.javafaker.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javafaker.service.FakeValuesService;

/**
 * The purpose of these tests is to ensure that the Locales have been properly configured
 * and that methods return values. The unit tests should ensure what the values returned
 * are correct. These tests just ensure that the methods can be invoked.
 */
public class MostSpecificLocaleIT {

    private FakeValuesService en;
    private FakeValuesService en_US;

    @BeforeEach
    public void setupFakers() {
        this.en = new FakeValuesService(new Locale("en"), null);
        this.en_US = new FakeValuesService(new Locale("en","US"), null);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void resolvesTheMostSpecificLocale() {
        final var enDefaultCountries = (List<String>) this.en.fetchObject("address.default_country");
        final var enUsDefaultCountries = (List<String>) this.en_US.fetchObject("address.default_country");

        assertThat(enDefaultCountries, hasSize(1));
        assertThat(enUsDefaultCountries, hasSize(3));

        assertThat("the default country for en is not en_US", enDefaultCountries, is(not(enUsDefaultCountries)));
    }
}
