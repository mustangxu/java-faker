package com.github.javafaker.service;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.CombinableMatcher.both;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.github.javafaker.AbstractFakerTest;

/**
 * @author pmiklos
 *
 */
@RunWith(Parameterized.class)
public class RandomServiceTest extends AbstractFakerTest {

    private RandomService randomService;

    @SuppressWarnings("unused")
    public RandomServiceTest(String ignoredTitle, RandomService service) {
        this.randomService = service;
    }

    @Parameterized.Parameters(name = "Created via {0}")
    public static Collection<Object[]> data() {
        Object[][] data = {
            {"RandomService(Random)", new RandomService(new Random())},
            {"RandomService()", new RandomService()}
        };
        return Arrays.asList(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveBoundariesOnly() {
        this.randomService.nextLong(0L);
    }

    @Test
    public void testLongWithinBoundary() {
        assertThat(this.randomService.nextLong(1), is(0L));

        for (var i = 1; i < 10; i++) {
            assertThat(this.randomService.nextLong(2), lessThan(2L));
        }
    }

    @Test
    public void testLongMaxBoundary() {
        assertThat(this.randomService.nextLong(Long.MAX_VALUE), greaterThan(0L));
        assertThat(this.randomService.nextLong(Long.MAX_VALUE), lessThan(Long.MAX_VALUE));
    }

    @Test
    public void testIntInRange() {
        for (var i = 1; i < 100; i++) {
            assertThat(this.randomService.nextInt(-5, 5), both(lessThanOrEqualTo(5)).and(greaterThanOrEqualTo(-5)));
        }
    }

    @Test
    public void testHex() {
        assertThat(this.randomService.hex(8), matchesRegularExpression("^[0-9A-F]{8}$"));
    }
    @Test
    public void testDefaultHex() {
        assertThat(this.randomService.hex(), matchesRegularExpression("^[0-9A-F]{8}$"));
    }
}
