package com.github.javafaker;

import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class EducatorTest extends AbstractFakerTest {

    @Test
    public void testUniversity() {
        assertThat(this.faker.educator().university(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void testCourse() {
        assertThat(this.faker.educator().course(), matchesRegularExpression("(\\(?\\w+\\)? ?){3,6}"));
    }

    @Test
    public void testSecondarySchool() {
        assertThat(this.faker.educator().secondarySchool(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void testCampus() {
        assertThat(this.faker.educator().campus(), matchesRegularExpression("(\\w+ ?){1,2}"));
    }
}
