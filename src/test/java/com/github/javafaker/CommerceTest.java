package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import java.text.DecimalFormatSymbols;

import org.junit.Test;

public class CommerceTest extends AbstractFakerTest {

    private static final char decimalSeparator = new DecimalFormatSymbols().getDecimalSeparator();

    private static final String CAPITALIZED_WORD_REGEX = "[A-Z][a-z]+";

    private static final String PROMOTION_CODE_REGEX = CAPITALIZED_WORD_REGEX + "(-" + CAPITALIZED_WORD_REGEX + ")*";

    @Test
    public void testColor() {
        assertThat(this.faker.commerce().color(), matchesRegularExpression("(\\w+ ?){1,2}"));
    }

    @Test
    public void testDepartment() {
        assertThat(this.faker.commerce().department(), matchesRegularExpression("(\\w+(, | & )?){1,3}"));
    }

    @Test
    public void testProductName() {
        assertThat(this.faker.commerce().productName(), matchesRegularExpression("(\\w+ ?){3,4}"));
    }

    @Test
    public void testMaterial() {
        assertThat(this.faker.commerce().material(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void testPrice() {
        assertThat(this.faker.commerce().price(), matchesRegularExpression("\\d{1,3}\\" + decimalSeparator + "\\d{2}"));
    }

    @Test
    public void testPriceMinMax() {
        assertThat(this.faker.commerce().price(100, 1000), matchesRegularExpression("\\d{3,4}\\" + decimalSeparator + "\\d{2}"));
    }

    @Test
    public void testPromotionCode() {
        assertThat(this.faker.commerce().promotionCode(), matchesRegularExpression(PROMOTION_CODE_REGEX + PROMOTION_CODE_REGEX + "\\d{6}"));
    }

    @Test
    public void testPromotionCodeDigits() {
        assertThat(this.faker.commerce().promotionCode(3), matchesRegularExpression(PROMOTION_CODE_REGEX + PROMOTION_CODE_REGEX + "\\d{3}"));
    }
}
