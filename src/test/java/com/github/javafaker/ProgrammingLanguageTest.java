package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ProgrammingLanguageTest extends AbstractFakerTest {

    @Test
    public void name() {
        assertThat(this.faker.programmingLanguage().name(), matchesRegularExpression("[A-Za-z0-9 :,.+*()#/\\–\\-@πéöü'′!]+"));
    }

    @Test
    public void creator() {
        assertThat(this.faker.programmingLanguage().creator(), matchesRegularExpression("[A-Za-z .,\\-]+"));
    }

}
