package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class BookTest extends AbstractFakerTest {

    @Test
    public void testTitle() {
        assertThat(this.faker.book().title(), matchesRegularExpression("([\\p{L}'\\-\\?]+[!,]? ?){2,9}"));
    }

    @Test
    public void testAuthor() {
        assertThat(this.faker.book().author(), matchesRegularExpression("([\\w']+\\.? ?){2,3}"));
    }

    @Test
    public void testPublisher() {
        assertThat(this.faker.book().publisher(), matchesRegularExpression("([\\p{L}'&\\-]+[,.]? ?){1,5}"));
    }

    @Test
    public void testGenre() {
        assertThat(this.faker.book().genre(), matchesRegularExpression("([\\w/]+ ?){2,4}"));
    }
}
