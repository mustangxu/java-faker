package com.github.javafaker.service;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.javafaker.AbstractFakerTest;
import com.github.javafaker.Faker;
import com.github.javafaker.Superhero;

public class FakeValuesServiceTest extends AbstractFakerTest {

    private static final Long MILLIS_IN_AN_HOUR = 1000 * 60 * 60L;
    private static final Long MILLIS_IN_A_DAY = MILLIS_IN_AN_HOUR * 24;

    @Mock
    private RandomService randomService;

    private FakeValuesService fakeValuesService;

    @Override
    @Before
    public void before() {
        super.before();
        MockitoAnnotations.initMocks(this);

        // always return the first element
        when(this.randomService.nextInt(anyInt())).thenReturn(0);

        this.fakeValuesService = spy(new FakeValuesService(new Locale("test"), this.randomService));
    }

    @Test
    public void fetchStringShouldReturnValue() {
        assertThat(this.fakeValuesService.fetchString("property.dummy"), is("x"));
    }

    @Test
    public void fetchShouldReturnValue() {
        assertThat(this.fakeValuesService.fetch("property.dummy"), Is.<Object>is("x"));
    }

    @Test
    public void fetchObjectShouldReturnValue() {
        assertThat(this.fakeValuesService.fetchObject("property.dummy"), Is.<Object>is(Arrays.asList("x", "y", "z")));
    }

    @Test
    public void safeFetchShouldReturnValueInList() {
        doReturn(0).when(this.randomService).nextInt(Mockito.anyInt());
        assertThat(this.fakeValuesService.safeFetch("property.dummy", null), is("x"));
    }

    @Test
    public void safeFetchShouldReturnSimpleList() {
        assertThat(this.fakeValuesService.safeFetch("property.simple", null), is("hello"));
    }

    @Test
    public void safeFetchShouldReturnEmptyStringWhenPropertyDoesntExist() {
        assertThat(this.fakeValuesService.safeFetch("property.dummy2", ""), isEmptyString());
    }

    @Test
    public void bothify2Args() {
        final var dummy = mock(DummyService.class);

        var f = new Faker();

        var value = this.fakeValuesService.resolve("property.bothify_2", dummy, f);
        assertThat(value, matchesRegularExpression("[A-Z]{2}\\d{2}"));
    }

    @Test
    public void regexifyDirective() {
        final var dummy = mock(DummyService.class);

        var value = this.fakeValuesService.resolve("property.regexify1", dummy, this.faker);
        assertThat(value, isOneOf("55", "44", "45", "54"));
        verify(this.faker).regexify("[45]{2}");
    }

    @Test
    public void regexifySlashFormatDirective() {
        final var dummy = mock(DummyService.class);

        var value = this.fakeValuesService.resolve("property.regexify_slash_format", dummy, this.faker);
        assertThat(value, isOneOf("55", "44", "45", "54"));
        verify(this.faker).regexify("[45]{2}");
    }

    @Test
    public void regexifyDirective2() {
        final var dummy = mock(DummyService.class);

        var value = this.fakeValuesService.resolve("property.regexify_cell", dummy, this.faker);
        assertThat(value, isOneOf("479", "459"));
        verify(this.faker).regexify("4[57]9");
    }

    @Test
    public void resolveKeyToPropertyWithAPropertyWithoutAnObject() {
        // #{hello} -> DummyService.hello

        // given
        final var dummy = mock(DummyService.class);
        doReturn("Yo!").when(dummy).hello();

        // when
        final var actual = this.fakeValuesService.resolve("property.simpleResolution", dummy, this.faker);

        // then
        assertThat(actual, is("Yo!"));
        verify(dummy).hello();
        verifyNoInteractions(this.faker);
    }

    @Test
    public void resolveKeyToPropertyWithAPropertyWithAnObject() {
        // given
        final var person = mock(Superhero.class);
        final var dummy = mock(DummyService.class);
        doReturn(person).when(this.faker).superhero();
        doReturn("Luke Cage").when(person).name();

        // when
        final var actual = this.fakeValuesService.resolve("property.advancedResolution", dummy, this.faker);

        // then
        assertThat(actual, is("Luke Cage"));
        verify(this.faker).superhero();
        verify(person).name();
    }

    @Test
    public void resolveKeyToPropertyWithAList() {
        // property.resolutionWithList -> #{hello}
        // #{hello} -> DummyService.hello

        // given
        final var dummy = mock(DummyService.class);
        doReturn(0).when(this.randomService).nextInt(Mockito.anyInt());
        doReturn("Yo!").when(dummy).hello();

        // when
        final var actual = this.fakeValuesService.resolve("property.resolutionWithList", dummy, this.faker);

        // then
        assertThat(actual, is("Yo!"));
        verify(dummy).hello();
    }

    @Test
    public void resolveKeyWithMultiplePropertiesShouldJoinResults() {
        // given
        final var person = mock(Superhero.class);
        final var dummy = mock(DummyService.class);
        doReturn(person).when(this.faker).superhero();

        doReturn("Yo Superman!").when(dummy).hello();
        doReturn("up up and away").when(person).descriptor();

        // when
        var actual = this.fakeValuesService.resolve("property.multipleResolution", dummy, this.faker);

        // then
        assertThat(actual, is("Yo Superman! up up and away"));

        verify(this.faker).superhero();
        verify(person).descriptor();
        verify(dummy).hello();
    }

    @Test
    public void testLocaleChain() {
        final var chain = this.fakeValuesService.localeChain(Locale.SIMPLIFIED_CHINESE);

        assertThat(chain, contains(Locale.SIMPLIFIED_CHINESE, Locale.CHINESE, Locale.ENGLISH));
    }

    @Test
    public void testLocaleChainEnglish() {
        final var chain = this.fakeValuesService.localeChain(Locale.ENGLISH);

        assertThat(chain, contains(Locale.ENGLISH));
    }

    @Test
    public void testLocaleChainLanguageOnly() {
        final var chain = this.fakeValuesService.localeChain(Locale.CHINESE);

        assertThat(chain, contains(Locale.CHINESE, Locale.ENGLISH));
    }

    @Test
    public void expressionWithInvalidFakerObject() {
        this.expressionShouldFailWith("#{ObjectNotOnFaker.methodName}",
                "Unable to resolve #{ObjectNotOnFaker.methodName} directive.");
    }

    @Test
    public void expressionWithValidFakerObjectButInvalidMethod() {
        this.expressionShouldFailWith("#{Name.nonExistentMethod}",
                "Unable to resolve #{Name.nonExistentMethod} directive.");
    }

    /**
     * Two things are important here:
     * 1) the message in the exception should be USEFUL
     * 2) a {@link RuntimeException} should be thrown.
     *
     * if the message changes, it's ok to update the test provided
     * the two conditions above are still true.
     */
    @Test
    public void expressionWithValidFakerObjectValidMethodInvalidArgs() {
        this.expressionShouldFailWith("#{Number.number_between 'x','y'}",
                "Unable to resolve #{Number.number_between 'x','y'} directive.");
    }

    @Test
    public void futureDateExpression() throws ParseException {
        var dateFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH  );

        var now = new Date();
        var nowPlus10Days = new Date( now.getTime() + MILLIS_IN_A_DAY * 10 );

        var date = dateFormat.parse( this.fakeValuesService.expression( "#{date.future '10','TimeUnit.DAYS'}", this.faker ));

        assertThat( date.getTime(), greaterThan( now.getTime() ));
        assertThat( date.getTime(), lessThan( nowPlus10Days.getTime() ));
    }

    @Test
    public void pastDateExpression() throws ParseException {
        var dateFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH );

        var now = new Date();
        var nowMinus5Hours = new Date( now.getTime() - MILLIS_IN_AN_HOUR * 5 );

        var date = dateFormat.parse( this.fakeValuesService.expression( "#{date.past '5','TimeUnit.HOURS'}", this.faker ));

        assertThat( date.getTime(), greaterThan( nowMinus5Hours.getTime() ));
        assertThat( date.getTime(), lessThan( now.getTime() ));
    }

    @Test
    public void expressionWithFourArguments() throws ParseException {

        assertThat(this.fakeValuesService.expression("#{Internet.password '5','8','true','true'}", this.faker),
            matchesRegularExpression("[\\w\\d\\!%#$@_\\^&\\*]{5,8}"));
    }

    /**
     * Two things are important here:
     * 1) the message in the exception should be USEFUL
     * 2) a {@link RuntimeException} should be thrown.
     *
     * if the message changes, it's ok to update the test provided
     * the two conditions above are still true.
     */
    @Test
    public void expressionCompletelyUnresolvable() {
        this.expressionShouldFailWith("#{x}", "Unable to resolve #{x} directive.");
    }

    private void expressionShouldFailWith(String expression, String errorMessage) {
        try {
            this.fakeValuesService.expression(expression, this.faker);
            fail("Should have failed with RuntimeException and message of " + errorMessage);
        } catch (RuntimeException re) {
            assertThat(re.getMessage(), is(errorMessage));
        }
    }
    @Test
    public void resolveUsingTheSameKeyTwice() {
        // #{hello} -> DummyService.hello

        // given
        final var dummy = mock(DummyService.class);
        when(dummy.hello()).thenReturn("1").thenReturn("2");

        // when
        final var actual = this.fakeValuesService.resolve("property.sameResolution", dummy, this.faker);

        // then
        assertThat(actual, is("1 2"));
        verifyNoInteractions(this.faker);
    }
    @Test
    public void FakeValuesServiceWithNullLocaleTest(){
        try{
            var r=new RandomService();
            var f=new FakeValuesService(null,r);
            fail("Should catch IllegalArgumentException");
        }catch (IllegalArgumentException e){
            assertThat(e.getMessage(),is("locale is required"));
        }
    }
    public static class DummyService {
        public String firstName() {
            return "John";
        }

        public String lastName() {
            return "Smith";
        }

        public String hello() {
            return "Hello";
        }
    }
}
