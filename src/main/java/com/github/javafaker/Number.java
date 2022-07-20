package com.github.javafaker;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Number {
    private final Faker faker;

    protected Number(Faker faker) {
        this.faker = faker;
    }

    /**
     * Returns a random number from 0-9 (both inclusive)
     */
    public int randomDigit() {
        return this.decimalBetween(0,10).intValue();
    }

    /**
     * Returns a random number from 1-9 (both inclusive)
     */
    public int randomDigitNotZero() {
        return this.decimalBetween(1,10).intValue();
    }

    /**
     * @see Number#numberBetween(long, long)
     */
    public int numberBetween(int min, int max) {
        if (min == max) {
            return min;
        }

        var value = this.decimalBetween(min, max)
                .setScale(0, RoundingMode.HALF_DOWN).intValue();
        return value == max ? value - 1 : value;
    }

    /**
     * Return a number between <em>min</em> and <em>max</em>.  If
     * min == max, then min is returned. So numberBetween(2,2) will yield 2 even though
     * it doesn't make sense.
     *
     * @param min inclusive
     * @param max exclusive (unless min == max)
     */
    public long numberBetween(long min, long max) {
        if (min == max) {
            return min;
        }

        var value = this.decimalBetween(min, max)
                .setScale(0, RoundingMode.HALF_DOWN).longValue();
        return value == max ? value - 1 : value;
    }

    /**
     * @param numberOfDigits the number of digits the generated value should have
     * @param strict         whether or not the generated value should have exactly <code>numberOfDigits</code>
     */
    public long randomNumber(int numberOfDigits, boolean strict) {
        var max = (long) Math.pow(10, numberOfDigits);
        if (strict) {
            var min = (long) Math.pow(10, numberOfDigits - 1);
            return this.faker.random().nextLong(max - min) + min;
        }

        return this.faker.random().nextLong(max);
    }

    /**
     * Returns a random number
     */
    public long randomNumber() {
        var numberOfDigits = this.decimalBetween(1,10).intValue();
        return this.randomNumber(numberOfDigits, false);
    }

    public double randomDouble(int maxNumberOfDecimals, int min, int max) {
        return this.randomDouble(maxNumberOfDecimals,(long) min, (long) max);
    }
    /**
     * Returns a random double
     *
     * @param maxNumberOfDecimals maximum number of places
     * @param min                 minimum value
     * @param max                 maximum value
     */
    public double randomDouble(int maxNumberOfDecimals, long min, long max) {
        return this.decimalBetween(min,max)
            .setScale(maxNumberOfDecimals, RoundingMode.HALF_DOWN)
                .doubleValue();
    }

    /**
     * @param min inclusive
     * @param max exclusive
     * @return
     */
    private BigDecimal decimalBetween(long min, long max) {
        if (min == max) {
            return new BigDecimal(min);
        }
        final var trueMin = Math.min(min, max);
        final var trueMax = Math.max(min, max);

        final var range = (double) trueMax - (double) trueMin;

        final var chunkCount = Math.sqrt(Math.abs(range));
        final var chunkSize = chunkCount;
        final var randomChunk = this.faker.random().nextLong((long) chunkCount);

        final var chunkStart = trueMin + randomChunk * chunkSize;
        final var adj = chunkSize * this.faker.random().nextDouble();
        return new BigDecimal(chunkStart + adj);
    }

    public String digits(int count) {
        final var tmp = new StringBuilder();
        for (var i = 0; i < count; i++) {
            tmp.append(this.randomDigit());
        }
        return tmp.toString();
    }

    public String digit() {
        return this.digits(1);
    }
}
