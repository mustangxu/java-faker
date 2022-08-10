package com.github.javafaker.service;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.javafaker.AbstractFakerTest;

/**
 * @author pmiklos
 *
 */
public class RandomServiceTest extends AbstractFakerTest {
    public static Stream<RandomService> data() {
        return Stream.of(
            new RandomService(new Random()),
            new RandomService());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPositiveBoundariesOnly(RandomService randomService) {
        assertThrows(IllegalArgumentException.class,
            () -> randomService.nextLong(0L));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLongWithinBoundary(RandomService randomService) {
        assertThat(randomService.nextLong(1), is(0L));

        for (var i = 1; i < 10; i++) {
            assertThat(randomService.nextLong(2), lessThan(2L));
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLongMaxBoundary(RandomService randomService) {
        assertThat(randomService.nextLong(Long.MAX_VALUE), greaterThan(0L));
        assertThat(randomService.nextLong(Long.MAX_VALUE),
            lessThan(Long.MAX_VALUE));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testIntInRange(RandomService randomService) {
        for (var i = 1; i < 100; i++) {
            assertThat(randomService.nextInt(-5, 5),
                both(lessThanOrEqualTo(5)).and(greaterThanOrEqualTo(-5)));
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testHex(RandomService randomService) {
        assertThat(randomService.hex(8),
            matchesRegularExpression("^[0-9A-F]{8}$"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testDefaultHex(RandomService randomService) {
        assertThat(randomService.hex(),
            matchesRegularExpression("^[0-9A-F]{8}$"));
    }
}
