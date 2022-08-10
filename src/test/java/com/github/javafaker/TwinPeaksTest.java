package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.Test;

public class TwinPeaksTest extends AbstractFakerTest {

    @Test
    public void character() {
        assertThat(this.faker.twinPeaks().character(), matchesRegularExpression("^([\\w']+ ?){2,}$"));
    }

    @Test
    public void location() {
        assertThat(this.faker.twinPeaks().location(), matchesRegularExpression("^[A-Za-z0-9'&,\\- ]+$"));
    }

    @Test
    public void quote() {
        assertThat(this.faker.twinPeaks().quote(), not(is(emptyOrNullString())));
    }
}
