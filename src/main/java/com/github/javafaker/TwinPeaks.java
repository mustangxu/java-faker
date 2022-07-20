package com.github.javafaker;

public class TwinPeaks {
    private final Faker faker;

    protected TwinPeaks(final Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.resolve("twin_peaks.characters");
    }

    public String location() {
        return this.faker.resolve("twin_peaks.locations");
    }

    public String quote() {
        return this.faker.resolve("twin_peaks.quotes");
    }
}
