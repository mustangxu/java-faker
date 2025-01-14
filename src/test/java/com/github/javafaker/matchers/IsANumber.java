package com.github.javafaker.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsANumber extends TypeSafeMatcher<String> {

    @Override
    protected boolean matchesSafely(String item) {
        try {
            Double.valueOf(item);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is a number");
    }

    public static Matcher<String> isANumber() {
        return new IsANumber();
    }
}
