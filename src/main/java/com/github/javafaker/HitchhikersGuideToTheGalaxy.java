package com.github.javafaker;

public class HitchhikersGuideToTheGalaxy {
    private final Faker faker;

    protected HitchhikersGuideToTheGalaxy(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("hitchhikers_guide_to_the_galaxy.characters", this, this.faker);
    }

    public String location() {
        return this.faker.fakeValuesService().resolve("hitchhikers_guide_to_the_galaxy.locations", this, this.faker);
    }

    public String marvinQuote() {
        return this.faker.fakeValuesService().resolve("hitchhikers_guide_to_the_galaxy.marvin_quote", this, this.faker);
    }

    public String planet() {
        return this.faker.fakeValuesService().resolve("hitchhikers_guide_to_the_galaxy.planets", this, this.faker);
    }

    public String quote() {
        return this.faker.fakeValuesService().resolve("hitchhikers_guide_to_the_galaxy.quotes", this, this.faker);
    }

    public String specie() {
        return this.faker.fakeValuesService().resolve("hitchhikers_guide_to_the_galaxy.species", this, this.faker);
    }

    public String starship() {
        return this.faker.fakeValuesService().resolve("hitchhikers_guide_to_the_galaxy.starships", this, this.faker);
    }
}
