package com.github.javafaker;

public class Coin {

    private final Faker faker;

    protected Coin(Faker faker) {
        this.faker = faker;
    }

    /**
     * @return coin side e.g. "Heads", "Tails".
     */
    public String flip() {
        return this.faker.fakeValuesService().resolve("coin.flip", this, this.faker);
    }
}
