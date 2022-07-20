package com.github.javafaker;

public class Team {
    private final Faker faker;

    protected Team(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("team.name", this, this.faker);
    }

    public String creature() {
        return this.faker.fakeValuesService().resolve("team.creature", this, this.faker);
    }

    public String state() {
        return this.faker.fakeValuesService().resolve("address.state", this, this.faker);
    }

    public String sport() {
        return this.faker.fakeValuesService().resolve("team.sport", this, this.faker);
    }
}
