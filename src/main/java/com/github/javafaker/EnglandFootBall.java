package com.github.javafaker;

public class EnglandFootBall {

    private final Faker faker;

    protected EnglandFootBall(final Faker faker) {
        this.faker = faker;
    }

    public String league() {
        return this.faker.fakeValuesService().resolve("englandfootball.leagues",this,this.faker);
    }

    public String team() {
        return this.faker.fakeValuesService().resolve("englandfootball.teams",this,this.faker);
    }
}
