package com.github.javafaker.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CountOfCharactersMatcher extends TypeSafeMatcher<String> {

    private final char character;
    private Matcher<Integer> matcher;

    public CountOfCharactersMatcher(char character, Matcher<Integer> matcher) {
        this.character = character;
        this.matcher = matcher;
    }

    public static Matcher<String> countOf(char character,
          Matcher<Integer> matcher) {
        return new CountOfCharactersMatcher(character, matcher);
    }

    @Override
    protected boolean matchesSafely(String item) {
        var count = this.count(item);
        return this.matcher.matches(count);
    }

    private int count(String item) {
        var count = 0;
        for (char c : item.toCharArray()) {
            count += c == this.character ? 1 : 0;
        }
        return count;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("count of " + this.character + " ").appendDescriptionOf(this.matcher);
    }

    @Override
    protected void describeMismatchSafely(String item, Description mismatchDescription) {
        mismatchDescription.appendText("count of " + this.character + " ");
        this.matcher.describeMismatch(this.count(item), mismatchDescription);
    }
}
