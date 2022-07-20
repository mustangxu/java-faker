package com.github.javafaker.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class FakeValuesGroupingTest {

    private FakeValuesGrouping fakeValuesGrouping;
    private FakeValues addressValues;

    @Before
    public void before() {
        this.fakeValuesGrouping = new FakeValuesGrouping();
        this.addressValues = new FakeValues(Locale.ENGLISH, "address.yml", "address");
        this.fakeValuesGrouping.add(this.addressValues);
    }

    @Test
    public void handlesOneFakeValue() {
        assertThat(this.fakeValuesGrouping.get("address"), is(this.addressValues.get("address")));
        assertThat(this.fakeValuesGrouping.get("address"), is(notNullValue()));
    }

    @Test
    public void handlesMultipleFakeValues() {
        var catValues = new FakeValues(Locale.ENGLISH, "cat.yml", "creature");
        this.fakeValuesGrouping.add(catValues);

        assertThat(this.fakeValuesGrouping.get("address"), is(this.addressValues.get("address")));
        assertThat(this.fakeValuesGrouping.get("address"), is(notNullValue()));

        assertThat(this.fakeValuesGrouping.get("creature"), is(catValues.get("creature")));
        assertThat(this.fakeValuesGrouping.get("creature"), is(notNullValue()));
    }
}
