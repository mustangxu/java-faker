package com.github.javafaker;

public class ElderScrolls {

    private final Faker faker;

    protected ElderScrolls(Faker faker) {
        this.faker = faker;
    }

    public String race() {
        return this.faker.fakeValuesService().resolve("games.elder_scrolls.race", this, this.faker);
    }

    public String creature() {
        return this.faker.fakeValuesService().resolve("games.elder_scrolls.creature", this, this.faker);
    }

    public String region() {
        return this.faker.fakeValuesService().resolve("games.elder_scrolls.region", this, this.faker);
    }

    public String dragon() {
        return this.faker.fakeValuesService().resolve("games.elder_scrolls.dragon", this, this.faker);
    }

    public String city() {
        return this.faker.fakeValuesService().resolve("games.elder_scrolls.city", this, this.faker);
    }

    public String firstName() {
        return this.faker.fakeValuesService().resolve("games.elder_scrolls.first_name", this, this.faker);
    }

    public String lastName() {
        return this.faker.fakeValuesService().resolve("games.elder_scrolls.last_name", this, this.faker);
    }

    public String quote() {return this.faker.fakeValuesService().resolve("games.elder_scrolls.quote", this, this.faker);
    }
}
