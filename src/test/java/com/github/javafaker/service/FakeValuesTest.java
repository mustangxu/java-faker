package com.github.javafaker.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;


public class FakeValuesTest {

    private static final String PATH = "address";
    private FakeValues fakeValues;

    @Before
    public void before() {
        this.fakeValues = new FakeValues(Locale.ENGLISH, "address.yml", PATH);
    }

    @Test
    public void supportsPathIsTrueWithTheSameValueAsThePath() {
        assertThat(this.fakeValues.supportsPath(PATH), is(true));
    }

    @Test
    public void supportsPathIsFalseWhenValueIsNotTheSame() {
        assertThat(this.fakeValues.supportsPath("dog"), is(false));
    }

    @Test
    public void getAValueReturnsAValue() {
        assertThat(this.fakeValues.get(PATH), is(notNullValue()));
    }

    @Test
    public void getAValueDoesNotReturnAValue() {
        assertThat(this.fakeValues.get("dog"), is(nullValue()));
    }

    @Test
    public void getAValueWithANonEnglishFile() {
        var frenchFakeValues = new FakeValues(Locale.FRENCH);
        assertThat(frenchFakeValues.get(PATH), is(notNullValue()));
    }

    @Test
    public void getAValueForHebrewLocale() {
        var hebrew = new FakeValues(new Locale("iw"));
        assertThat(hebrew.get(PATH), is(notNullValue()));
    }

    @Test
    public void getAValueFromALocaleThatCantBeLoaded() {
        this.fakeValues = new FakeValues(new Locale("nothing"));
        assertThat(this.fakeValues.get(PATH), is(nullValue()));
    }

}
