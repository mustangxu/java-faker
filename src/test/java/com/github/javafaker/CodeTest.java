package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.util.Locale;

import org.apache.commons.validator.routines.ISBNValidator;
import org.apache.commons.validator.routines.checkdigit.EAN13CheckDigit;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.junit.Test;

import com.github.javafaker.repeating.Repeat;

public class CodeTest extends AbstractFakerTest {

    private static final ISBNValidator ISBN_VALIDATOR = ISBNValidator.getInstance(false);

    @Test
    @Repeat(times = 1000)
    public void isbn10DefaultIsNoSeparator() {
        var isbn10 = this.faker.code().isbn10();

        CodeTest.assertIsValidISBN10(isbn10);
        assertThat(isbn10, not(containsString("-")));
    }

    @Test
    @Repeat(times = 1000)
    public void isbn13DefaultIsNoSeparator() {
        var isbn13 = this.faker.code().isbn13();

        CodeTest.assertIsValidISBN13(isbn13);
        assertThat(isbn13, not(containsString("-")));
    }

    @Test
    @Repeat(times = 1000)
    public void testIsbn10() {
        final var isbn10NoSep = this.faker.code().isbn10(false);
        final var isbn10Sep = this.faker.code().isbn10(true);

        assertThat(isbn10NoSep + " is not null", isbn10NoSep, is(not(nullValue())));
        assertThat(isbn10NoSep + " has length of 10", isbn10NoSep.length(), is(10));
        CodeTest.assertIsValidISBN10(isbn10NoSep);

        assertThat(isbn10Sep + " is not null", isbn10Sep, is(not(nullValue())));
        assertThat(isbn10Sep + " has length of 13", isbn10Sep.length(), is(13));
        CodeTest.assertIsValidISBN10(isbn10Sep);
    }

    @Test
    @Repeat(times = 1000)
    public void testIsbn13() {
        final var isbn13NoSep = this.faker.code().isbn13(false);
        final var isbn13Sep = this.faker.code().isbn13(true);

        assertThat(isbn13NoSep + " is not null", isbn13NoSep, is(not(nullValue())));
        assertThat(isbn13NoSep + " has length of 13", isbn13NoSep.length(), is(13));
        assertIsValidISBN13(isbn13NoSep);

        assertThat(isbn13Sep + " is not null", isbn13Sep, is(not(nullValue())));
        assertThat(isbn13Sep + " has length of 17", isbn13Sep.length(), is(17));
        assertIsValidISBN13(isbn13Sep);
    }

    private static void assertIsValidISBN10(String isbn10) {
        assertThat(isbn10 + " is valid", ISBN_VALIDATOR.isValidISBN10(isbn10), is(true));
    }

    private static void assertIsValidISBN13(String isbn13) {
        assertThat(isbn13 + " is valid", ISBN_VALIDATOR.isValidISBN13(isbn13), is(true));
    }

    @Test
    @Repeat(times = 100)
    public void testOverrides() {
        this.faker = new Faker(new Locale("test"));

        final var isbn10Sep = this.faker.code().isbn10(true);
        final var isbn13Sep = this.faker.code().isbn13(true);

        assertThat("Uses overridden expressions from test.yml",
            isbn10Sep,
            matchesRegularExpression("9971-\\d-\\d{4}-(\\d|X)"));

        assertThat("Uses overridden expressions from test.yml",
            isbn13Sep,
            matchesRegularExpression("(333|444)-9971-\\d-\\d{4}-\\d"));
    }

    @Test
    public void asin() {
        assertThat(this.faker.code().asin(), matchesRegularExpression("B000([A-Z]|\\d){6}"));
    }

    @Test
    public void imei() {
        var imei = this.faker.code().imei();

        assertThat(imei, matchesRegularExpression("\\A[\\d\\.\\:\\-\\s]+\\z"));
        assertThat(LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(imei), is(true));
    }

    @Test
    public void ean8() {
        assertThat(this.faker.code().ean8(), matchesRegularExpression("\\d{8}"));
    }

    @Test
    public void gtin8() {
        assertThat(this.faker.code().gtin8(), matchesRegularExpression("\\d{8}"));
    }

    @Test
    public void ean13() {
        var ean13 = this.faker.code().ean13();
        assertThat(ean13, matchesRegularExpression("\\d{13}"));
        assertThat(EAN13CheckDigit.EAN13_CHECK_DIGIT.isValid(ean13), is(true));
    }

    @Test
    public void gtin13() {
        var gtin13 = this.faker.code().gtin13();
        assertThat(gtin13, matchesRegularExpression("\\d{13}"));
        assertThat(EAN13CheckDigit.EAN13_CHECK_DIGIT.isValid(gtin13), is(true));
    }
}
