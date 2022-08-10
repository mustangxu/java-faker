package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.junit.jupiter.api.Test;

public class FinanceTest extends AbstractFakerTest {

    @Test
    public void creditCard() {
        for (var i = 0; i < 100; i++) {
            final var creditCard = this.faker.finance().creditCard();
            assertCardLuhnDigit(creditCard);
        }
    }

    private static void assertCardLuhnDigit(String creditCard) {
        final var creditCardStripped = creditCard.replace("-", "");
        assertThat(LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(creditCardStripped), is(true));
    }

    @Test
    public void bic() {
        assertThat(this.faker.finance().bic(), matchesRegularExpression("([A-Z]){4}([A-Z]){2}([0-9A-Z]){2}([0-9A-Z]{3})?"));
    }

    @Test
    public void iban() {
        assertThat(this.faker.finance().iban(), matchesRegularExpression("[A-Z]{2}\\p{Alnum}{13,30}"));
    }

    @Test
    public void ibanWithCountryCode() {
        assertThat(this.faker.finance().iban("DE"), matchesRegularExpression("DE\\d{20}"));
    }

    @Test
    public void creditCardWithType() {
        for(CreditCardType type : CreditCardType.values()) {
            final var creditCard = this.faker.finance().creditCard(type);
            assertCardLuhnDigit(creditCard);
        }
    }
}
