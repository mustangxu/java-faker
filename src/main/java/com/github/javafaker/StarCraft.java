package com.github.javafaker;

public class StarCraft {

    private final Faker faker;

    protected StarCraft(final Faker faker) {
        this.faker = faker;
    }

    public String unit() {
        return this.faker.fakeValuesService().resolve("starcraft.units", this, this.faker);
    }

    public String building() {
        return this.faker.fakeValuesService().resolve("starcraft.buildings", this, this.faker);
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("starcraft.characters", this, this.faker);
    }

    public String planet() {
        return this.faker.fakeValuesService().resolve("starcraft.planets", this, this.faker);
    }

}
