package com.github.javafaker;

public class HowIMetYourMother {
    private final Faker faker;

    protected HowIMetYourMother(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("how_i_met_your_mother.character", this, this.faker);
    }

    public String catchPhrase() {
        return this.faker.fakeValuesService().resolve("how_i_met_your_mother.catch_phrase", this, this.faker);
    }

    public String highFive() {
        return this.faker.fakeValuesService().resolve("how_i_met_your_mother.high_five", this, this.faker);
    }

    public String quote() {
        return this.faker.fakeValuesService().resolve("how_i_met_your_mother.quote", this, this.faker);
    }
}
