package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;

public class RickAndMortyTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.rickAndMorty().character(), matchesRegularExpression("^([\\w'-.]+ ?){2,}$"));
    }

    @Test
    public void location() {
        assertThat(this.faker.rickAndMorty().location(), matchesRegularExpression("^([\\w-.]+ ?){2,}$"));
    }

    @Test
    public void quote() {
        assertThat(this.faker.rickAndMorty().quote(), not(is(emptyOrNullString())));
    }
}
