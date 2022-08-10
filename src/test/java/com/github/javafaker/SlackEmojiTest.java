package com.github.javafaker;

import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class SlackEmojiTest extends AbstractFakerTest {

    private static final String EMOTICON_REGEX = ":([\\w-]+):";

    @Test
    public void people() {
        assertThat(this.faker.slackEmoji().people(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void nature() {
        assertThat(this.faker.slackEmoji().nature(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void food_and_drink() {
        assertThat(this.faker.slackEmoji().foodAndDrink(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void celebration() {
        assertThat(this.faker.slackEmoji().celebration(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void activity() {
        assertThat(this.faker.slackEmoji().activity(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void travel_and_places() {
        assertThat(this.faker.slackEmoji().travelAndPlaces(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void objects_and_symbols() {
        assertThat(this.faker.slackEmoji().objectsAndSymbols(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void custom() {
        assertThat(this.faker.slackEmoji().custom(), matchesRegularExpression(EMOTICON_REGEX));
    }

    @Test
    public void emoji() {
        assertThat(this.faker.slackEmoji().emoji(), matchesRegularExpression(EMOTICON_REGEX));
    }
}
