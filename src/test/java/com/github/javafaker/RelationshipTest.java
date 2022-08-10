package com.github.javafaker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RelationshipTest extends AbstractFakerTest {

    private Faker mockFaker;

    @Override
    @BeforeEach
    public void before() throws Exception {
        super.before();
        this.mockFaker = Mockito.mock(Faker.class);
    }

    @Test
    public void anyTest() {
        assertThat(this.faker.relationships().any(), not(is(emptyOrNullString())));
    }

    @Test
    public void directTest() {
        assertThat(this.faker.relationships().direct(), not(is(emptyOrNullString())));
    }

    @Test
    public void extendedTest() {
        assertThat(this.faker.relationships().extended(), not(is(emptyOrNullString())));
    }

    @Test
    public void inLawTest() {
        assertThat(this.faker.relationships().inLaw(), not(is(emptyOrNullString())));
    }

    @Test
    public void spouseTest() {
        assertThat(this.faker.relationships().spouse(), not(is(emptyOrNullString())));
    }

    @Test
    public void parentTest() {
        assertThat(this.faker.relationships().parent(), not(is(emptyOrNullString())));
    }

    @Test
    public void siblingTest() {
        assertThat(this.faker.relationships().sibling(), not(is(emptyOrNullString())));
    }

    @Test
    public void anyWithIllegalArgumentExceptionThrown() {
        assertThrows(RuntimeException.class, () -> {
            when(this.mockFaker.random())
            .thenThrow(new IllegalArgumentException());
            new Relationships(this.mockFaker).any();
        });
    }

    @Test
    public void anyWithSecurityExceptionThrown() {
        assertThrows( RuntimeException.class,()->{  when(this.mockFaker.random()).thenThrow(new SecurityException());
        new Relationships(this.mockFaker).any();
        });
    }

    @Test
    public void anyWithIllegalAccessExceptionThrown() {
        assertThrows(RuntimeException.class, () -> {
            when(this.mockFaker.random())
            .thenThrow(new IllegalAccessException());
            new Relationships(this.mockFaker).any();
        });
    }

    @Test
    public void anyWithInvocationTargetExceptionThrown() {
        assertThrows(RuntimeException.class, () -> {
            when(this.mockFaker.random())
            .thenThrow(new InvocationTargetException(new Exception()));
            new Relationships(this.mockFaker).any();
        });
    }

}
