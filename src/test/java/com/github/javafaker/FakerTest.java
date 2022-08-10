package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.github.javafaker.repeating.Repeat;

public class FakerTest extends AbstractFakerTest {

    @Test
    public void bothifyShouldGenerateLettersAndNumbers() {
        assertThat(this.faker.bothify("????##@gmail.com"), matchesRegularExpression("\\w{4}\\d{2}@gmail.com"));
    }

    @Test
    public void letterifyShouldGenerateLetters() {
        assertThat(this.faker.bothify("????"), matchesRegularExpression("\\w{4}"));
    }

    @Test
    public void letterifyShouldGenerateUpperCaseLetters() {
        assertThat(this.faker.bothify("????",true), matchesRegularExpression("[A-Z]{4}"));
    }

    @Test
    public void letterifyShouldLeaveNonSpecialCharactersAlone() {
        assertThat(this.faker.bothify("ABC????DEF"), matchesRegularExpression("ABC\\w{4}DEF"));
    }

    @Test
    public void numerifyShouldGenerateNumbers() {
        assertThat(this.faker.numerify("####"), matchesRegularExpression("\\d{4}"));
    }

    @Test
    public void numerifyShouldLeaveNonSpecialCharactersAlone() {
        assertThat(this.faker.numerify("####123"), matchesRegularExpression("\\d{4}123"));
    }

    @Test
    public void regexifyShouldGenerateNumbers() {
        assertThat(this.faker.regexify("\\d"), matchesRegularExpression("\\d"));
    }

    @Test
    public void regexifyShouldGenerateLetters() {
        assertThat(this.faker.regexify("\\w"), matchesRegularExpression("\\w"));
    }

    @Test
    public void regexifyShouldGenerateAlternations() {
        assertThat(this.faker.regexify("(a|b)"), matchesRegularExpression("(a|b)"));
    }

    @Test
    public void regexifyShouldGenerateBasicCharacterClasses() {
        assertThat(this.faker.regexify("(aeiou)"), matchesRegularExpression("(aeiou)"));
    }

    @Test
    public void regexifyShouldGenerateCharacterClassRanges() {
        assertThat(this.faker.regexify("[a-z]"), matchesRegularExpression("[a-z]"));
    }

    @Test
    public void regexifyShouldGenerateMultipleCharacterClassRanges() {
        assertThat(this.faker.regexify("[a-z1-9]"), matchesRegularExpression("[a-z1-9]"));
    }

    @Test
    public void regexifyShouldGenerateSingleCharacterQuantifiers() {
        assertThat(this.faker.regexify("a*b+c?"), matchesRegularExpression("a*b+c?"));
    }

    @Test
    public void regexifyShouldGenerateBracketsQuantifiers() {
        assertThat(this.faker.regexify("a{2}"), matchesRegularExpression("a{2}"));
    }

    @Test
    public void regexifyShouldGenerateMinMaxQuantifiers() {
        assertThat(this.faker.regexify("a{2,3}"), matchesRegularExpression("a{2,3}"));
    }

    @Test
    public void regexifyShouldGenerateBracketsQuantifiersOnBasicCharacterClasses() {
        assertThat(this.faker.regexify("[aeiou]{2,3}"), matchesRegularExpression("[aeiou]{2,3}"));
    }

    @Test
    public void regexifyShouldGenerateBracketsQuantifiersOnCharacterClassRanges() {
        assertThat(this.faker.regexify("[a-z]{2,3}"), matchesRegularExpression("[a-z]{2,3}"));
    }

    @Test
    public void regexifyShouldGenerateBracketsQuantifiersOnAlternations() {
        assertThat(this.faker.regexify("(a|b){2,3}"), matchesRegularExpression("(a|b){2,3}"));
    }

    @Test
    public void regexifyShouldGenerateEscapedCharacters() {
        assertThat(this.faker.regexify("\\.\\*\\?\\+"), matchesRegularExpression("\\.\\*\\?\\+"));
    }

    @Test
    public void badExpressionTooManyArgs() {
        assertThrows( RuntimeException.class, ()->
        this.faker.expression("#{regexify 'a','a'}"));
    }

    @Test
    public void badExpressionTooFewArgs() {
        assertThrows(RuntimeException.class,
            () -> this.faker.expression("#{regexify}"));
    }

    @Test
    public void badExpressionCouldntCoerce() {
        assertThrows(RuntimeException.class,
            () -> this.faker.expression("#{number.number_between 'x','10'}"));
    }

    @Test
    public void expression() {
        assertThat(this.faker.expression("#{regexify '(a|b){2,3}'}"), matchesRegularExpression("(a|b){2,3}"));
        assertThat(this.faker.expression("#{regexify '\\.\\*\\?\\+'}"), matchesRegularExpression("\\.\\*\\?\\+"));
        assertThat(this.faker.expression("#{bothify '????','true'}"), matchesRegularExpression("[A-Z]{4}"));
        assertThat(this.faker.expression("#{bothify '????','false'}"), matchesRegularExpression("[a-z]{4}"));
        assertThat(this.faker.expression("#{letterify '????','true'}"), matchesRegularExpression("[A-Z]{4}"));
        assertThat(this.faker.expression("#{Name.first_name} #{Name.first_name} #{Name.last_name}"), matchesRegularExpression("[a-zA-Z']+ [a-zA-Z']+ [a-zA-Z']+"));
        assertThat(this.faker.expression("#{number.number_between '1','10'}"), matchesRegularExpression("[1-9]"));
        assertThat(this.faker.expression("#{color.name}"), matchesRegularExpression("[a-z\\s]+"));
    }

    @Test
    @Repeat(times = 100)
    public void numberBetweenRepeated() {
        assertThat(this.faker.expression("#{number.number_between '1','10'}"), matchesRegularExpression("[1-9]"));
    }

    @Test
    public void regexifyShouldGenerateSameValueForFakerWithSameSeed() {
        var seed = 1L;
        var regex = "\\d";

        var firstResult = new Faker(new Random(seed)).regexify(regex);
        var secondResult = new Faker(new Random(seed)).regexify(regex);

        assertThat(secondResult, is(firstResult));
    }

    @Test
    public void resolveShouldReturnValueThatExists() {
        assertThat(this.faker.resolve("address.city_prefix"), not(is(emptyString())));
    }

    @Test
    public void resolveShouldThrowExceptionWhenPropertyDoesntExist() {
        assertThrows(RuntimeException.class, () -> {
            final var resolve = this.faker.resolve("address.nothing");
            assertThat(resolve, is(nullValue()));
        });
    }

    @Test
    public void fakerInstanceCanBeAcquiredViaUtilityMethods() {
        assertThat(Faker.instance(), is(instanceOf(Faker.class)));
        assertThat(Faker.instance(Locale.CANADA), is(instanceOf(Faker.class)));
        assertThat(Faker.instance(new Random(1)), is(instanceOf(Faker.class)));
        assertThat(Faker.instance(Locale.CHINA, new Random(2)), is(instanceOf(Faker.class)));
    }
}
