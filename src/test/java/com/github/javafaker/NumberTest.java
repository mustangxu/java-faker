package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.repeating.Repeat;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class NumberTest extends AbstractFakerTest {

    private static final Logger logger = LoggerFactory.getLogger(NumberTest.class);
    public static final int RANDOMIZATION_QUALITY_RANGE_END = 1000;
    public static final int RANDOMIZATION_QUALITY_RANGE_STEP = 25;
    private static final int RANDOMIZATION_QUALITY_RANGE_START = RANDOMIZATION_QUALITY_RANGE_STEP;
    public static final int RANDOMIZATION_TESTS_MAX_NUMBERS_TO_GET = 1000;

    final double individualRunGtPercentUnique= 0.8;
    final double percentRunsGtUniquePercentage = 0.90;

    @Test
    public void testRandomDigit() {
        Set<Integer> nums = Sets.newHashSet();
        for (var i = 0; i < 1000; ++i) {
            var value = this.faker.number().randomDigit();
            assertThat(value, is(lessThanOrEqualTo(9)));
            assertThat(value, is(greaterThanOrEqualTo(0)));
            nums.add(value);
        }
        assertThat(nums, contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testRandomDigitNotZero() {
        Set<Integer> nums = Sets.newHashSet();
        for (var i = 0; i < 1000; ++i) {
            var value = this.faker.number().randomDigitNotZero();
            assertThat(value, is(lessThanOrEqualTo(9)));
            assertThat(value, is(greaterThan(0)));
            nums.add(value);
        }
        assertThat(nums, contains(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testRandomNumber() {
        var value = this.faker.number().randomNumber();
        assertThat(value, is(lessThan(Long.MAX_VALUE)));
    }

    @Test
    public void testRandomNumberWithSingleDigitStrict() {
        for (var i = 0; i < 100; ++i) {
            var value = this.faker.number().randomNumber(1, true);
            assertThat(value, is(lessThan(10L)));
            assertThat(value, is(greaterThanOrEqualTo(0L)));
        }
    }

    @Test
    public void testRandomNumberWithZeroDigitsStrict() {
        for (var i = 0; i < 100; ++i) {
            var value = this.faker.number().randomNumber(0, true);
            assertThat(value, is(0L));
        }
    }

    @Test
    public void testRandomNumberWithGivenDigitsStrict() {
        for (var i = 1; i < 9; ++i) {
            for (var x = 0; x < 100; ++x) {
                var value = this.faker.number().randomNumber(i, true);
                var stringValue = String.valueOf(value);
                assertThat(stringValue.length(), is(i));
            }
        }
    }

    @Test
    public void testRandomDouble() {
        for (var i = 1; i < 5; ++i) {
            for (var x = 0; x < 100; ++x) {
                var value = this.faker.number().randomDouble(i, 1, 1000);
                var strVal = BigDecimal.valueOf(value).stripTrailingZeros().toString();
                if (strVal.contains(".") && !strVal.contains("+")) {
                    var ind = strVal.indexOf(".");
                    assertThat(strVal.length() - ind - 1, is(lessThanOrEqualTo(i)));
                }
            }
        }
    }

    @Test
    public void testNumberBetween() {
        for (var i = 1; i < 100; ++i) {
            var v = this.faker.number().numberBetween(0, i);
            assertThat(v, is(lessThanOrEqualTo(i)));
            assertThat(v, is(greaterThanOrEqualTo(0)));
        }

        for (var i = 1L; i < 100L; ++i) {
            var v = this.faker.number().numberBetween(0, i);
            assertThat(v, is(lessThanOrEqualTo(i)));
            assertThat(v, is(greaterThanOrEqualTo(0L)));
        }

        var min1 = 1;
        var v1 = this.faker.number().numberBetween(min1, 980000000L);
        assertThat(v1, is(greaterThan((long) min1)));
        assertThat(v1, is(lessThan(980000000L)));
    }

    @Test
    @Repeat(times = 100)
    public void testLongNumberBetweenRepeated() {
        var low = 1L;
        var high = 10L;
        var v = this.faker.number().numberBetween(low, high);
        assertThat(v, is(lessThan(high)));
        assertThat(v, is(greaterThanOrEqualTo(low)));
    }

    @Test
    @Repeat(times = 100)
    public void testIntNumberBetweenRepeated() {
        var low = 1;
        var high = 10;
        var v = this.faker.number().numberBetween(low, high);
        assertThat(v, is(lessThan(high)));
        assertThat(v, is(greaterThanOrEqualTo(low)));
    }

    @Test
    public void testNumberBetweenOneAndThree() {
        Set<Integer> nums = Sets.newHashSet();
        final var lowerLimit = 0;
        final var upperLimit = 3;
        for (var i = 0; i < 1000; ++i) {
            var value = this.faker.number().numberBetween(lowerLimit, upperLimit);
            assertThat(value, is(lessThan(upperLimit)));
            assertThat(value, is(greaterThanOrEqualTo(lowerLimit)));
            nums.add(value);
        }
        assertThat(nums, contains(0, 1, 2));
    }

    @Test
    public void testLongBetweenOneAndThree() {
        Set<Long> nums = Sets.newHashSet();
        final var lowerLimit = 0L;
        final var upperLimit = 3L;
        for (var i = 0; i < 1000; ++i) {
            var value = this.faker.number().numberBetween(lowerLimit, upperLimit);
            assertThat(value, is(lessThan(upperLimit)));
            assertThat(value, is(greaterThanOrEqualTo(lowerLimit)));
            nums.add(value);
        }
        assertThat(nums, contains(0L, 1L, 2L));
    }

    @Test
    public void numberBetweenIntIntZeroMinMax() {
        assertThat("Calling numberBetween with min==max yields min, with 0",
            this.faker.number().numberBetween(0, 0),
            is(0));
        assertThat("Calling numberBetween with min==max yields min",
            this.faker.number().numberBetween(2, 2),
            is(2));
    }

    @Test
    public void numberBetweenLongLongZeroMinMax() {
        assertThat("Calling numberBetween with min==max yields min, with 0",
            this.faker.number().numberBetween(0L, 0L),
            is(0L));
        assertThat("Calling numberBetween with min==max yields min",
            this.faker.number().numberBetween(2L, 2L),
            is(2L));
    }

    /**
     * Given a number of min/max ranges
     *  for each min/max range, call {@link Number#randomDouble(int, int, int)} with min/max 'n' times
     *  calculate the uniqueness for that given min/max range.
     * For all 'uniqueness' values
     *  verify the percentage of 'uniqueness' ratios over 80% is 90%.
     *
     * This isn't perfect but it ensures a pretty good degree of uniqueness in the random number generation.
     */
    @Test
    public void randomDoubleRandomizationQuality() {
        Function<Pair<Long, Long>, Double> minMaxRangeToUniquePercentageFunction = minMax -> {
            final int min = minMax.getLeft().intValue(), max = minMax.getRight().intValue();
            var numbersToGet = NumberTest.calculateNumbersToGet(min, max);

            return NumberTest.uniquePercentageOfResults(numbersToGet, () -> NumberTest.this.faker.number().randomDouble(0, min, max));
        };

        final var percentGreaterThan80Percent = NumberTest.randomizationQualityTest(this.individualRunGtPercentUnique, minMaxRangeToUniquePercentageFunction);
        assertThat("Percentage of runs > 80% unique is gte 90%",
            percentGreaterThan80Percent, greaterThanOrEqualTo(this.percentRunsGtUniquePercentage));

        // this covers Issue # 121, the number of times the function is called with the MIN/MAX values here
        // is RANDOMIZATION_TESTS_MAX_NUMBERS_TO_GET
        final double extremeRunUniquePercent = minMaxRangeToUniquePercentageFunction.apply(Pair.of((long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE));
        assertThat("Percentage of extreme runs > 80%",
            extremeRunUniquePercent, greaterThanOrEqualTo(this.individualRunGtPercentUnique));
    }

    /**
     * Given a number of min/max ranges
     *  for each min/max range, call numberBetween with min/max 'n' times
     *  calculate the uniqueness for that given min/max range.
     * For all 'uniqueness' values
     *  verify the percentage of 'uniqueness' ratios over 80% is 90%.
     *
     * This isn't perfect but it ensures a pretty good degree of uniqueness in the random number generation.
     */
    @Test
    public void numberBetweenIntIntRandomizationQuality() {
        Function<Pair<Long, Long>, Double> minMaxRangeToUniquePercentageFunction = minMax -> {
            final var min = minMax.getLeft().intValue();
            final var max = minMax.getRight().intValue();
            var numbersToGet = NumberTest.calculateNumbersToGet(min, max);

            return NumberTest.uniquePercentageOfResults(numbersToGet, () -> NumberTest.this.faker.number().numberBetween(min, max));
        };

        final var percentGreaterThan80Percent = NumberTest.randomizationQualityTest(this.individualRunGtPercentUnique, minMaxRangeToUniquePercentageFunction);
        assertThat("Percentage of runs > 80% unique is gte 90%",
            percentGreaterThan80Percent, greaterThanOrEqualTo(this.percentRunsGtUniquePercentage));

        // this covers Issue # 121, the number of times the function is called with the MIN/MAX values here
        // is RANDOMIZATION_TESTS_MAX_NUMBERS_TO_GET
        final double extremeRunUniquePercent = minMaxRangeToUniquePercentageFunction.apply(Pair.of((long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE));
        assertThat("Percentage of extreme runs > 80%",
            extremeRunUniquePercent, greaterThanOrEqualTo(this.individualRunGtPercentUnique));
    }

    /**
     * Given a number of min/max ranges
     *  for each min/max range, call {@link Number#numberBetween(long, long)}  with min/max 'n' times
     *  calculate the uniqueness for that given min/max range.
     * For all 'uniqueness' values
     *  verify the percentage of 'uniqueness' ratios over 80% is 90%.
     *
     * This isn't perfect but it ensures a pretty good degree of uniqueness in the random number generation.
     */
    @Test
    public void numberBetweenLongLongRandomizationQuality() {
        Function<Pair<Long, Long>, Double> minMaxRangeToUniquePercentageFunction = minMax -> {
            final long min = minMax.getLeft(), max = minMax.getRight();
            var numbersToGet = NumberTest.calculateNumbersToGet(min, max);

            return NumberTest.uniquePercentageOfResults(numbersToGet, () -> NumberTest.this.faker.number().numberBetween(min, max));
        };

        final var percentGreaterThan80Percent = NumberTest.randomizationQualityTest(this.individualRunGtPercentUnique, minMaxRangeToUniquePercentageFunction);
        assertThat("Percentage of runs > 80% unique is gte 90%",
            percentGreaterThan80Percent, greaterThanOrEqualTo(this.percentRunsGtUniquePercentage));

        // this covers Issue # 121, the number of times the function is called with the MIN/MAX values here
        // is RANDOMIZATION_TESTS_MAX_NUMBERS_TO_GET.
        final double extremeRunUniquePercent = minMaxRangeToUniquePercentageFunction.apply(Pair.of(Long.MIN_VALUE, Long.MAX_VALUE));
        assertThat("Percentage of extreme runs > 80%",
            extremeRunUniquePercent, greaterThanOrEqualTo(this.individualRunGtPercentUnique));
    }

    @Test
    public void testRandomDoubleMaxEqualsMin() {
        var actual = this.faker.number().randomDouble(1, 42, 42);

        var expected = BigDecimal.valueOf(42).doubleValue();

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testDigit() {
        var digit = this.faker.number().digit();

        assertThat(digit, matchesRegularExpression("[0-9]"));
    }

    @Test
    public void testDigits() {
        var digits = this.faker.number().digits(5);

        assertThat(digits, matchesRegularExpression("[0-9]{5}"));
    }

    /**
     * Over the series of numbers identified from RANDOMIZATION_QUALITY_RANGE_START to
     * RANDOMIZATION_QUALITY_RANGE_END, create a min/max range of -value/value and
     * with of those min/max values, call <em>percentUniqueRunner</em>.
     *
     * Collect the number of calls to <em>percentUniqueRunner</em> that were
     * above the threshold and finally return that number divided by the total number of calls to
     * <em>percentUniqueRunner</em>.
     *
     * @return percent of percentUniqueRunner's results greater than the threshold
     */
    private static double randomizationQualityTest(final double threshold,
            final Function<Pair<Long,Long>,Double> percentUniqueRunner) {
        final var rangeEnd = RANDOMIZATION_QUALITY_RANGE_END;
        final var rangeStep = RANDOMIZATION_QUALITY_RANGE_STEP;
        final var rangeStart = RANDOMIZATION_QUALITY_RANGE_START;

        final var greaterThanThreshold = new AtomicLong();
        final var total = new AtomicLong();

        for (long l = rangeStart; l < rangeEnd; l += rangeStep) {
            final double percentUnique = percentUniqueRunner.apply(Pair.of(-l,l));
            logger.info("Range {} to {} is {} percent unique.", -l, l, percentUnique);
            if (percentUnique > threshold) {
                greaterThanThreshold.incrementAndGet();
            }
            total.incrementAndGet();
        }

        return (double) greaterThanThreshold.get() / (double) total.get();
    }


    /**
     * Given a number of iterations, calls <em>callable</em> 'iterations' times and collects the results,
     * then calculates the number of results that were unique and returns the percentage that where unique.
     */
    private static <T> double uniquePercentageOfResults(long iterations,
            Callable<T> callable) {
        try {
            List<T> values = Lists.newArrayList();
            for (var i = 0L; i < iterations; i++) {
                values.add(callable.call());
            }
            long setSize = Sets.newHashSet(values).size();
            return (double) setSize / (double) values.size();
        } catch (Exception e) {
            logger.error("error in uniquePercentageOfResults", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * given a range, what is the number of values to get within that range for the randomization quality tests.
     */
    private static long calculateNumbersToGet(long min, long max) {
        var numbersToGet = Math.min((max - min) / 4, RANDOMIZATION_TESTS_MAX_NUMBERS_TO_GET);
        if (numbersToGet == 0) {
            numbersToGet = RANDOMIZATION_TESTS_MAX_NUMBERS_TO_GET;
        }
        return numbersToGet;
    }
}
