package com.github.javafaker;

/**
 * Generate random parts in BojackHorseman.
 * @author unknown and irakatz
 */

public class BojackHorseman {
    private final Faker faker;

    /**
     * Create a constructor for BojackHorseman.
     * @param faker The Faker instance for generating random parts in BojackHorseman.
     */
    protected BojackHorseman(Faker faker) {
        this.faker = faker;
    }

    /**
     * Generate random character's name in BojackHorseman.
     * @return Characters in BojackHorseman
     */
    public String characters() {
        return this.faker.fakeValuesService().resolve("bojack_horseman.characters", this, this.faker);
    }

    /**
     * Generate random quotes in BojackHorseman.
     * @return Quotes in BojackHorseman
     */
    public String quotes() {
        return this.faker.fakeValuesService().resolve("bojack_horseman.quotes", this, this.faker);
    }

    /**
     * Generate random tongue twisters in BojackHorseman.
     * @return Tongue twisters in BojackHorseman
     */
    public String tongueTwisters() {
        return this.faker.fakeValuesService().resolve("bojack_horseman.tongue_twisters", this, this.faker);
    }

}
