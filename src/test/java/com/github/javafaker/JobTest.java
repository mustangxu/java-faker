package com.github.javafaker;

import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobTest extends AbstractFakerTest {

    @Test
    public void field() {
        assertThat(this.faker.job().field(), matchesRegularExpression("^[A-Z][A-Za-z-]+$"));
    }

    @Test
    public void seniority() {
        assertThat(this.faker.job().seniority(), matchesRegularExpression("^[A-Z][a-z]+$"));
    }

    @Test
    public void position() {
        assertThat(this.faker.job().position(), matchesRegularExpression("^[A-Z][a-z]+$"));
    }

    @Test
    public void keySkills() {
        assertThat(this.faker.job().keySkills(), matchesRegularExpression("([A-Za-z-]+ ?){1,3}"));
    }

    @Test
    public void title() {
        assertThat(this.faker.job().title(), matchesRegularExpression("([A-Za-z-]+ ?){2,3}"));
    }
}
